package com.dfliu.patterns.controller;

import com.dfliu.patterns.domain.constants.ResponseType;
import com.dfliu.patterns.domain.constants.ResultCode;
import com.dfliu.patterns.domain.dto.Result;
import com.dfliu.patterns.service.chain.*;
import com.dfliu.patterns.service.strategy.ConcreteStrategy2;
import com.dfliu.patterns.service.strategy.Context;
import jdk.internal.org.objectweb.asm.Handle;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 行为型模式
 */
@RestController
@RequestMapping(value = "/behavior")
public class BehaviorController extends BaseContoller {

    /**
     * 策略模式示例
     *
     * @return
     */
    @RequestMapping(value = "/strategyPattern")
    public Result<String> strategyPattern() {
        Context context = new Context();
        context.setStrategy(new ConcreteStrategy2());
        context.doSomething();

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "策略模式示例");
        return build;
    }

    /**
     * 职责链模式示例
     *
     * @return
     */
    @RequestMapping(value = "/chainPattern")
    public Result<String> chainPattern() {
        IWomen women = new Women(ResponseType.HUSBAND.getCode(), "我要去菜场");
        Handler son = new SonHandler();
        Handler husband = new HusbandHandler();
        Handler father = new FatherHandler();
        son.setNextHandler(husband);
        husband.setNextHandler(father);
        son.handler(women);

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "职责链模式示例");
        return build;
    }
}