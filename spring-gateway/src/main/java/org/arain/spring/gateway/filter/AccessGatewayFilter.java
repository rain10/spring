//package org.arain.spring.gateway.filter;
//
//import java.net.URI;
//import java.nio.charset.StandardCharsets;
//import java.util.Iterator;
//import java.util.LinkedHashSet;
//
//import javax.validation.constraints.NotNull;
//
//import org.arain.spring.common.msg.BaseResponse;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.web.server.ServerWebExchange;
//
//import com.alibaba.fastjson.JSONObject;
//
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
///**
// * 
// * @author arain
// *
// */
//@Configuration
//public class AccessGatewayFilter implements GlobalFilter {
//
//    @Value("${gate.ignore.startWith}")
//    private String startWith;
//
//
//    private static final String GATE_WAY_PREFIX = "/api";
//   
//    @SuppressWarnings({ "unchecked", "rawtypes" })
//	@Override
//    public Mono<Void> filter(ServerWebExchange serverWebExchange, GatewayFilterChain gatewayFilterChain) {
//        LinkedHashSet requiredAttribute = serverWebExchange.getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR);
//        ServerHttpRequest request = serverWebExchange.getRequest();
//        String requestUri = request.getPath().pathWithinApplication().value();
//        if (requiredAttribute != null) {
//            Iterator<URI> iterator = requiredAttribute.iterator();
//            while (iterator.hasNext()){
//                URI next = iterator.next();
//                if(next.getPath().startsWith(GATE_WAY_PREFIX)){
//                    requestUri = next.getPath().substring(GATE_WAY_PREFIX.length());
//                }
//            }
//        }
//        ServerHttpRequest.Builder mutate = request.mutate();
//        // 不进行拦截的地址
//        if (isStartWith(requestUri)) {
//            ServerHttpRequest build = mutate.build();
//            return gatewayFilterChain.filter(serverWebExchange.mutate().request(build).build());
//        }
//        ServerHttpRequest build = mutate.build();
//        return gatewayFilterChain.filter(serverWebExchange.mutate().request(build).build());
//
//    }
//
//    /**
//     * 网关抛异常
//     *
//     * @param body
//     */
//    @NotNull
//    private Mono<Void> getVoidMono(ServerWebExchange serverWebExchange, BaseResponse body) {
//        serverWebExchange.getResponse().setStatusCode(HttpStatus.OK);
//        byte[] bytes = JSONObject.toJSONString(body).getBytes(StandardCharsets.UTF_8);
//        DataBuffer buffer = serverWebExchange.getResponse().bufferFactory().wrap(bytes);
//        return serverWebExchange.getResponse().writeWith(Flux.just(buffer));
//    }
//
//    /**
//     * URI是否以什么打头
//     *
//     * @param requestUri
//     * @return
//     */
//    private boolean isStartWith(String requestUri) {
//        boolean flag = false;
//        for (String s : startWith.split(",")) {
//            if (requestUri.startsWith(s)) {
//                return true;
//            }
//        }
//        return flag;
//    }
//}
