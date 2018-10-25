package org.arain.spring.common.inside.base.controller;

import org.arain.spring.common.inside.result.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author arain
 * @date 2018年10月25日 下午12:20:56
 */
public abstract class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    protected ResultMap success() {
        return ResultMap.ok();
    }

    protected ResultMap success(Object data) {
        return ResultMap.ok(data);
    }

    protected ResultMap faild(String erroMsg) {
        return ResultMap.build(0, erroMsg);
    }

    protected ResultMap faild() {
        return ResultMap.build(0, "");
    }
}
