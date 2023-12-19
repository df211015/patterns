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
import com.dfliu.patterns.service.mediator.*;
import com.dfliu.patterns.service.memento.Caretaker;
import com.dfliu.patterns.service.memento.Memento;
import com.dfliu.patterns.service.memento.Originator;
import com.dfliu.patterns.service.state.ChildWorkState;
import com.dfliu.patterns.service.state.WorkState;
import com.dfliu.patterns.service.strategy.ConcreteStrategy2;
import com.dfliu.patterns.service.strategy.Context;
import com.dfliu.patterns.service.subscribe.ObserverOf163;
import com.dfliu.patterns.service.subscribe.SubjectOf163;
import com.dfliu.patterns.service.template.AbsAnimal;
import com.dfliu.patterns.service.template.Dog;
import jdk.internal.org.objectweb.asm.Handle;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Observable;
import java.util.Observer;

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

    /**
     * 中介者模式示例
     *
     * @return
     */
    @RequestMapping(value = "/mediatorPattern")
    public Result<String> mediatorPattern() {
        Mediator mediator = new ConcreteMediator();
        Colleague colleague1 = new ConcreteColleague1(mediator);
        Colleague colleague2 = new ConcreteColleague2(mediator);
        mediator.setConcreteColleague1(colleague1);
        mediator.setConcreteColleague2(colleague2);
        colleague1.dosomething();
        colleague2.dosomething();

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "中介者模式示例");
        return build;
    }

    /**
     * 模板方法模式示例
     *
     * @return
     */
    @RequestMapping(value = "/templatePattern")
    public Result<String> templatePattern() {
        AbsAnimal dog = new Dog();
        dog.showAnimalInfo();

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "模板方法模式示例");
        return build;
    }

    /**
     * 观察者模式示例
     *
     * @return
     */
    @RequestMapping(value = "/subscribePattern")
    public Result<String> subscribePattern() {
        SubjectOf163 subjectOf163 = new SubjectOf163();
        Observer observerOf163 = new ObserverOf163();
        subjectOf163.addObserver(observerOf163);
        subjectOf163.sendCheckCode("12345678901");

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "观察者模式示例");
        return build;
    }

    /**
     * 涉及角色:发起人(Originator)角色、备忘录(Memento)角色、负责人(Caretaker)角色
     * 最终的数据呈现还是通过发起人(Originator)角色来体现
     *
     * @return
     */
    @RequestMapping(value = "/mementoPattern")
    public Result<String> mementoPattern() {
        Originator originator = new Originator();
        originator.setData("第1次初始化");
        Memento mementoOfFirst = originator.createMemento();
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(mementoOfFirst);
        originator.setData("第2次初始化");
        System.out.println(String.format("originator最新数据:%s", originator.getData()));
        originator.restoreMemento(caretaker.getMemento());
        System.out.println(String.format("originator最新数据:%s", originator.getData()));

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "备忘录模式示例");
        return build;
    }
}