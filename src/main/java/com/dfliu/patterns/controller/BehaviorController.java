package com.dfliu.patterns.controller;

import com.dfliu.patterns.domain.constants.Compare;
import com.dfliu.patterns.domain.constants.ResponseType;
import com.dfliu.patterns.domain.constants.ResultCode;
import com.dfliu.patterns.domain.dto.Passenger;
import com.dfliu.patterns.domain.dto.Result;
import com.dfliu.patterns.service.chain.*;
import com.dfliu.patterns.service.command.AbsCommand;
import com.dfliu.patterns.service.command.ConcreteCommand;
import com.dfliu.patterns.service.command.ConcreteReceive;
import com.dfliu.patterns.service.command.IReceive;
import com.dfliu.patterns.service.interpreter.AndExpression;
import com.dfliu.patterns.service.interpreter.Expression;
import com.dfliu.patterns.service.interpreter.TerminalExpression;
import com.dfliu.patterns.service.interpreterplus.Free;
import com.dfliu.patterns.service.mediator.*;
import com.dfliu.patterns.service.memento.Caretaker;
import com.dfliu.patterns.service.memento.Memento;
import com.dfliu.patterns.service.memento.Originator;
import com.dfliu.patterns.service.servant.IServiced;
import com.dfliu.patterns.service.servant.Servant;
import com.dfliu.patterns.service.servant.Service1;
import com.dfliu.patterns.service.state.plus.MediaPlayer;
import com.dfliu.patterns.service.strategy.ConcreteStrategy2;
import com.dfliu.patterns.service.strategy.Context;
import com.dfliu.patterns.service.subscribe.ObserverOf163;
import com.dfliu.patterns.service.subscribe.SubjectOf163;
import com.dfliu.patterns.service.template.AbsAnimal;
import com.dfliu.patterns.service.template.Dog;
import com.dfliu.patterns.service.visitor.plus.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

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
        List<Handler> lstHandler = Arrays.asList(son, husband, father);
        List<Handler> collect = lstHandler.stream().sorted(Comparator.comparing(Handler::getOrderNo)).collect(Collectors.toList());
        Handler head = collect.get(0);
        Handler tmp = head;
        for (Handler h : collect) {
            if (tmp != h) {
                tmp.setNextHandler(h);
                tmp = h;
            }
        }
        head.handler(women);

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
//        //状态模式01
//        com.dfliu.patterns.service.state.Context context = new com.dfliu.patterns.service.state.Context();
//        context.setCurrentByState(EState.CHILD);
//        context.work();
//        context.work();
//        context.work();
        //状态模式02
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.play();
        mediaPlayer.pause();
        mediaPlayer.play();
        mediaPlayer.stop();

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

    /**
     * 访问者模式示例
     *
     * @return
     */
    @RequestMapping(value = "/visitorPattern")
    public Result<String> visitorPattern() {
//        CommonEmployee commonEmployee = new CommonEmployee();
//        commonEmployee.setUserName("员工001");
//        commonEmployee.setSalary(5000);
//        commonEmployee.setDesc("北京科技公司");
//        commonEmployee.setJobName("研发岗位");
//        Manager manager = new Manager();
//        manager.setUserName("研发经理001");
//        manager.setSalary(8000);
//        manager.setDesc("北京科技公司");
//        manager.setPerformance("绩效A");
//        IVisitor visitor = new Visitor();
//        commonEmployee.accept(visitor);
//        manager.accept(visitor);

        Dot dot = new Dot(1, 10, 55);
        Circle circle = new Circle(2, 23, 15, 10);
        Rectangle rectangle = new Rectangle(3, 10, 17, 20, 30);

        CompoundShape compoundShape = new CompoundShape(4);
        compoundShape.add(dot);

        XmlExportVisitor exportVisitor = new XmlExportVisitor();
        List<Shape> lstShape = Arrays.asList(dot, circle, rectangle);
        String strExport = exportVisitor.export(lstShape);
        System.out.println(strExport);

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "访问者模式示例");
        return build;
    }

    /**
     * 解释器模式示例
     *
     * @return
     */
    @RequestMapping(value = "/interpretPattern")
    public Result<String> interpretPattern() {
        Expression left = new TerminalExpression("music");
        Expression right = new TerminalExpression("art");
        AndExpression andExpression = new AndExpression(left, right);
        boolean musicAndMath = andExpression.interpret("music and art");
        System.out.println(String.format("musicAndMath:%s", musicAndMath ? "匹配" : "不匹配"));

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "解释器模式示例");
        return build;
    }

    /**
     * 解释器模式plus示例
     *
     * @return
     */
    @RequestMapping(value = "/interpretPlusPattern")
    public Result<String> interpretPlusPattern() {
        //定义乘客集合
        List<Passenger> list = new ArrayList<>();
        Passenger p1 = new Passenger("张三", 65, 170.0);
        Passenger p2 = new Passenger("李四", 10, 130.0);
        Passenger p3 = new Passenger("王五", 50, 170.0);
        list.add(p1);
        list.add(p2);
        list.add(p3);

        //所有年龄大于等于65或者身高小于等于130的乘客免费乘车
        for (Passenger p : list) {
            //定义免费标准
            Free free = new Free(65, 130);
            //满足条件则免费
            if (free.result(p.getAge(), p.getHeight())) {
                System.out.println(p.getName() + "：免费");
            } else {
                System.out.println(p.getName() + "：请刷卡或投币");
            }
        }
        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "解释器模式plus示例");
        return build;
    }

    /**
     * 雇工模式示例
     *
     * @return
     */
    @RequestMapping(value = "/servantPattern")
    public Result<String> servantPattern() {
        IServiced serivice = new Service1();
        Servant servant = new Servant();
        servant.service(serivice);

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "雇工模式示例");
        return build;
    }
}