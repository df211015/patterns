package com.dfliu.patterns.controller;

import com.dfliu.patterns.domain.constants.ResultCode;
import com.dfliu.patterns.domain.dto.Result;
import com.dfliu.patterns.service.adapter.Adaptee;
import com.dfliu.patterns.service.adapter.Adapter;
import com.dfliu.patterns.service.adapter.IAdaptee;
import com.dfliu.patterns.service.bridge.Abstraction;
import com.dfliu.patterns.service.bridge.ConcreteImplementor;
import com.dfliu.patterns.service.bridge.Implementor;
import com.dfliu.patterns.service.bridge.RefinedAbstraction;
import com.dfliu.patterns.service.composite.Component;
import com.dfliu.patterns.service.composite.Composite;
import com.dfliu.patterns.service.composite.Leaf;
import com.dfliu.patterns.service.decorate.AbsOilPaint;
import com.dfliu.patterns.service.decorate.LivingRoom;
import com.dfliu.patterns.service.decorate.Polish;
import com.dfliu.patterns.service.decorate.Putty;
import com.dfliu.patterns.service.facade.Facade;
import com.dfliu.patterns.service.flyweight.FlyweightFactory;
import com.dfliu.patterns.service.flyweight.IFlyweight;
import com.dfliu.patterns.service.flyweight.UnsharedConcreteFlyweight;
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
    @RequestMapping(value = "/proxyPattern")
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
    @RequestMapping(value = "/decoratePattern")
    public Result<String> decoratePattern() {
        AbsOilPaint oilPaint = new LivingRoom();
        oilPaint = new Polish(oilPaint);
        oilPaint = new Putty(oilPaint);
        oilPaint.paint("郭师傅");

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "装饰模式示例");
        return build;
    }

    /**
     * 适配器模式示例
     *
     * @return
     */
    @RequestMapping(value = "/adapterPattern")
    public Result<String> adapterPattern() {
        IAdaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter();
        adaptee.adapteeObj();
        adapter.setAdaptee(adaptee);
        adapter.targetObj();

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "适配器模式示例");
        return build;
    }

    /**
     * 享元模式示例
     *
     * @return
     */
    @RequestMapping(value = "/flyweightPattern")
    public Result<String> flyweightPattern() {
        FlyweightFactory factory = new FlyweightFactory();
        IFlyweight f01 = factory.getFlyweight("a");
        IFlyweight f02 = factory.getFlyweight("a");
        IFlyweight f03 = factory.getFlyweight("a");
        f01.operation(new UnsharedConcreteFlyweight("第1次调用a"));
        f02.operation(new UnsharedConcreteFlyweight("第2次调用a"));
        f03.operation(new UnsharedConcreteFlyweight("第3次调用a"));

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "享元模式示例");
        return build;
    }

    /**
     * 桥接模式示例
     *
     * @return
     */
    @RequestMapping(value = "/bridgePattern")
    public Result<String> bridgePattern() {
        Implementor implementor = new ConcreteImplementor();
        Abstraction abstraction = new RefinedAbstraction(implementor);
        abstraction.request();

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "桥接模式示例");
        return build;
    }

    /**
     * 组合模式示例
     *
     * @return
     */
    @RequestMapping(value = "/compositePattern")
    public Result<String> compositePattern() {
        Component root = new Composite("总纲");
        Component group1 = new Composite("组1");
        Component group2 = new Composite("组2");
        root.add(group1);
        root.add(group2);
        Component item1 = new Leaf("结点1");
        Component item2 = new Leaf("结点2");
        group1.add(item1);
        group1.add(item2);
        root.display(0);

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "组合模式示例");
        return build;
    }

    /**
     * 门面模式示例
     *
     * @return
     */
    @RequestMapping(value = "/facadePattern")
    public Result<String> facadePattern() {
        Facade facade = new Facade();
        facade.doSomething();

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "门面模式示例");
        return build;
    }
}