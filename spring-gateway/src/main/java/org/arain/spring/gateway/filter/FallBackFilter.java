package org.arain.spring.gateway.filter;

import org.arain.spring.common.inside.result.ResultEnum;
import org.arain.spring.common.inside.result.ResultMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Arain
 * @date 2018年10月19日 上午9:11:11
 */
@RestController
public class FallBackFilter {
	
	@RequestMapping("fallBackRequest")
	public ResultMap fallBackRequest() {
		return ResultMap.build(ResultEnum.ERROR.getCode(), "网关内部服务请求超时，请稍后重试");
	}
}
