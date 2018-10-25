package org.arain.spring.gateway.filter;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.StringUtils;
import org.arain.spring.common.inside.result.ResultMap;
import org.arain.spring.gateway.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.alibaba.fastjson.JSONObject;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author Arain
 * @date 2018年10月19日 上午10:41:41
 */
@Component
public class AccessTokenFilter implements GlobalFilter {

	@Value("${auth-anonymous}")
	private String anonymous;
	
	@Value("${auth-authenticationInfo}")
	private String authenticationInfo;

	@Value("${token-header}")
	private String tokenHeader;

	@Autowired
	private AuthService authService;

	private static final String GATE_WAY_PREFIX = "/api";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Mono<Void> filter(ServerWebExchange serverWebExchange, GatewayFilterChain gatewayFilterChain) {
		LinkedHashSet requiredAttribute = serverWebExchange
				.getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR);
		ServerHttpRequest request = serverWebExchange.getRequest();
		String requestUri = request.getPath().pathWithinApplication().value();
		if (requiredAttribute != null) {
			Iterator<URI> iterator = requiredAttribute.iterator();
			while (iterator.hasNext()) {
				URI next = iterator.next();
				if (next.getPath().startsWith(GATE_WAY_PREFIX)) {
					requestUri = next.getPath().substring(GATE_WAY_PREFIX.length());
				}
			}
		}
		String method = request.getMethod().toString();
		ServerHttpRequest.Builder mutate = request.mutate();
        if (isAnonymous(requestUri)) {
            ServerHttpRequest build = mutate.build();
            return gatewayFilterChain.filter(serverWebExchange.mutate().request(build).build());
        }
        
        if (isAauthenticationInfo(requestUri)) {
            ServerHttpRequest build = mutate.build();
            return gatewayFilterChain.filter(serverWebExchange.mutate().request(build).build());
        }
        
		Map<String, Object> object = getJWTUser(request, mutate);
		if (org.springframework.util.StringUtils.isEmpty(object) || org.springframework.util.StringUtils.isEmpty(object.get("serialNo"))) {
			return getVoidMono(serverWebExchange, ResultMap.build(0, "用户token过期，请重新登录"));
		}

		String serialNo = (String) object.get("serialNo");
		List<Map<String, Object>> allPermissionInfo = getAllPermissionInfo();
		Map<String, Object> permission = checkMethodAndReturnPermission(allPermissionInfo, method, requestUri);
		if ((boolean) permission.get("isNotOk")) {
			return getVoidMono(serverWebExchange, ResultMap.build(0, "请求方式错误或访问不存在，请重试"));
		}

		List<Map<String, Object>> permissionByUserSerialNo = getPermissionByUserSerialNo(serialNo);

		if (!checkPermission(permission, permissionByUserSerialNo)) {
			return getVoidMono(serverWebExchange, ResultMap.build(0, "你没有权限访问，请联系管理员"));
		}
		ServerHttpRequest build = mutate.build();
		return gatewayFilterChain.filter(serverWebExchange.mutate().request(build).build());

	}

	/**
	 * 网关抛异常
	 *
	 * @param body
	 */
	@NotNull
	private Mono<Void> getVoidMono(ServerWebExchange serverWebExchange, ResultMap body) {
		serverWebExchange.getResponse().setStatusCode(HttpStatus.OK);
		byte[] bytes = JSONObject.toJSONString(body).getBytes(StandardCharsets.UTF_8);
		DataBuffer buffer = serverWebExchange.getResponse().bufferFactory().wrap(bytes);
		serverWebExchange.getResponse().getHeaders().add("Content-Type", "application/json;charset=UTF-8");
		return serverWebExchange.getResponse().writeWith(Flux.just(buffer));
	}
	
	/**
	 * 获取登录用户信息
	 * @param request
	 * @param ctx
	 * @return
	 */
	private Map<String, Object> getJWTUser(ServerHttpRequest request, ServerHttpRequest.Builder ctx) {
		List<String> strings = request.getHeaders().get(tokenHeader);
		String authToken = null;
		if (strings != null) {
			authToken = strings.get(0);
		}
		if (StringUtils.isBlank(authToken)) {
			strings = request.getQueryParams().get(tokenHeader);
			if (strings != null) {
				authToken = strings.get(0);
			}
		}
		ctx.header(tokenHeader, authToken);
		Map<String, Object> data = authService.loadJWTInfo(authToken);
		return data;
	}

	/**
	 * 加载所有权限
	 * @return
	 */
	private List<Map<String, Object>> getAllPermissionInfo() {
		List<Map<String, Object>> list = authService.getAllPermissionInfo();
		return list;
	}

	/**
	 * 加载用户权限
	 * @param serialNo
	 * @return
	 */
	private List<Map<String, Object>> getPermissionByUserSerialNo(String serialNo) {
		List<Map<String, Object>> list = authService.getPermissionByUserSerialNo(serialNo);
		return list;
	}

	/**
	 * 检查请求方法是否有效并返回有效权限
	 * @param allPermissionInfo
	 * @param method
	 * @param requestUri
	 * @return
	 */
	private Map<String, Object> checkMethodAndReturnPermission(List<Map<String, Object>> allPermissionInfo,
			String method, String requestUri) {
		Map<String, Object> permission = new HashMap<>();
		permission.put("url", requestUri);
		for (Map<String, Object> map : allPermissionInfo) {
			if (requestUri.equals(map.get("url"))) {
				permission.put("code", map.get("code"));
				if (!org.springframework.util.StringUtils.isEmpty(map.get("method"))) {
					if (method.equals(map.get("method"))) {
						permission.put("isNotOk", false);
						return permission;
					}
				} else {
					permission.put("isNotOk", false);
					return permission;
				}
			}
		}
		permission.put("isNotOk", true);
		return permission;
	}

	/**
	 * 检查权限
	 * @param permission
	 * @param user
	 * @return
	 */
	private boolean checkPermission(Map<String, Object> permission, List<Map<String, Object>> user) {
		boolean anyMatch = user.parallelStream().anyMatch(new Predicate<Map<String, Object>>() {
			@Override
			public boolean test(Map<String, Object> permissionInfo) {
				return permissionInfo.get("code").equals(permission.get("code"));
			}
		});
		return anyMatch;
	}

	/**
	 *匿名登录排除
	 *
	 * @param requestUri
	 * @return
	 */
	private boolean isAnonymous(String requestUri) {
		boolean flag = false;
		for (String s : anonymous.split(",")) {
			if(s.indexOf("**") != -1) {
				int i = s.indexOf("**");
				String url = s.substring(0,i);
				if(requestUri.startsWith(url)) {
					return true;
				}
			}else {
				if(requestUri.equals(s)) {
					return true;
				}
			}
		}
		return flag;
	}
	
	/**
	 *登录后排除
	 *
	 * @param requestUri
	 * @return
	 */
	private boolean isAauthenticationInfo(String requestUri) {
		boolean flag = false;
		for (String s : authenticationInfo.split(",")) {
			if(s.indexOf("**") != -1) {
				int i = s.indexOf("**");
				String url = s.substring(0,i);
				if(requestUri.startsWith(url)) {
					return true;
				}
			}else {
				if(requestUri.equals(s)) {
					return true;
				}
			}
		}
		return flag;
	}
}
