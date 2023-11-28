package com.dfliu.patterns.controller;

import com.dfliu.patterns.domain.constants.EState;
import com.dfliu.patterns.domain.constants.ResponseType;
import com.dfliu.patterns.domain.constants.ResultCode;
import com.dfliu.patterns.domain.dto.Result;
import com.dfliu.patterns.service.chain.*;
import com.dfliu.patterns.service.command.AbsCommand;
import com.dfliu.patterns.service.command.ConcreteCommand;
import com.dfliu.patterns.service.command.ConcreteReceive;
import com.dfliu.patterns.service.command.IReceive;
import com.dfliu.patterns.service.state.ChildWorkState;
import com.dfliu.patterns.service.state.WorkState;
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
        IWomen women = new Women(ResponseType.FATHER.getCode(), "我要去超市");
        Handler son = new SonHandler();
        Handler husband = new HusbandHandler();
        Handler father = new FatherHandler();
        son.setNextHandler(husband);
        husband.setNextHandler(father);
        son.handler(women);

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "职责链模式示例");
        return build;
    }

    /**
     * 状态模式示例
     *
     * @return
     */
    @RequestMapping(value = "/statePattern")
    public Result<String> statePattern() {
        com.dfliu.patterns.service.state.Context context = new com.dfliu.patterns.service.state.Context();
        context.setCurrentByState(EState.CHILD);
        context.work();
        context.work();
        context.work();

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "状态模式示例");
        return build;
    }

    /**
     * 命令模式示例
     *
     * @return
     */
    @RequestMapping(value = "/commandPattern")
    public Result<String> commandPattern() {
        IReceive receive = new ConcreteReceive();
        AbsCommand command = new ConcreteCommand(receive);
        command.order("place an order");

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "命令模式示例");
        return build;
    }
}