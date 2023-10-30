package com.dfliu.patterns.controller;

import com.dfliu.patterns.domain.constants.ResultCode;
import com.dfliu.patterns.domain.dto.Result;
import com.dfliu.patterns.service.proxy.GuoWorker;
import com.dfliu.patterns.service.proxy.IDecorate;
import com.dfliu.patterns.service.proxy.Proxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 结构型模式
 */
@RestController
@RequestMapping(value = "/struct")
public class StructController extends BaseContoller {

    /**
     * 代理模式示例
     *
     * @return
     */
    @RequestMapping(value = "proxyPattern")
    public Result<String> proxyPattern() {
        IDecorate worker = new GuoWorker();
        IDecorate decorate = new Proxy(worker);
        decorate.decorate("小张");

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "代理模式示例");
        return build;
    }
}