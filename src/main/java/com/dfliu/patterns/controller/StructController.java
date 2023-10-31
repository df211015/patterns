package com.dfliu.patterns.controller;

import com.dfliu.patterns.domain.constants.ResultCode;
import com.dfliu.patterns.domain.dto.Result;
import com.dfliu.patterns.service.decorate.AbsOilPaint;
import com.dfliu.patterns.service.decorate.LivingRoom;
import com.dfliu.patterns.service.decorate.Polish;
import com.dfliu.patterns.service.decorate.Putty;
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

    /**
     * 装饰模式示例
     *
     * @return
     */
    @RequestMapping(value = "decoratePattern")
    public Result<String> decoratePattern() {
        AbsOilPaint oilPaint = new LivingRoom();
        oilPaint = new Polish(oilPaint);
        oilPaint = new Putty(oilPaint);
        oilPaint.paint("郭师傅");

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "装饰模式示例");
        return build;
    }
}