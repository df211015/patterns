package com.dfliu.patterns.controller;

import com.alibaba.fastjson.JSON;
import com.dfliu.patterns.domain.constants.ResultCode;
import com.dfliu.patterns.domain.dto.Bread;
import com.dfliu.patterns.domain.dto.DecrorateHouse;
import com.dfliu.patterns.domain.dto.Pizza;
import com.dfliu.patterns.domain.dto.Result;
import com.dfliu.patterns.service.builder.AbsBuilder;
import com.dfliu.patterns.service.builder.BBuilder;
import com.dfliu.patterns.service.factory.abstractFactory.AbsPizzaPlusFactory;
import com.dfliu.patterns.service.factory.abstractFactory.CheesePizzaPlusFactory;
import com.dfliu.patterns.service.factory.factoryMethod.AbsPizzaFactory;
import com.dfliu.patterns.service.factory.factoryMethod.CheesePizzaFactory;
import com.dfliu.patterns.service.factory.simpleFactory.SimplePizzaFactory;
import com.dfliu.patterns.service.prototype.Thing;
import com.dfliu.patterns.service.singleton.ProjConstants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/factory")
public class FactoryController extends BaseContoller {
    /**
     * 简单工厂模式示例
     */
    @RequestMapping(value = "/simpleFactoryPattern")
    public Result<String> simpleFactoryPattern() {
        Pizza pepper = SimplePizzaFactory.getInstanceOfPizza("pepper");
        if (null != pepper) {
            String pizzaName = pepper.getPizzaName();
            System.out.println(pizzaName);
        }

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "简单工厂模式示例");
        return build;
    }

    /**
     * 工厂方法模式示例
     */
    @RequestMapping(value = "/factoryMethodPattern")
    public Result<String> factoryMethodPattern() {
        AbsPizzaFactory pizzaFactory = new CheesePizzaFactory();
        Pizza cheesePizza = pizzaFactory.createPizza();
        if (null != cheesePizza) {
            String pizzaName = cheesePizza.getName();
            System.out.println(pizzaName);
        }

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "工厂方法模式示例");
        return build;
    }

    /**
     * 抽象工厂模式示例
     */
    @RequestMapping(value = "/abstractFactoryPattern")
    public Result<String> abstractFactoryPattern() {
        AbsPizzaPlusFactory cheesePizzaPlusFactory = new CheesePizzaPlusFactory();
        Pizza pizza = cheesePizzaPlusFactory.createdPizza();
        Bread bread = cheesePizzaPlusFactory.createBread();
        if (null != pizza) {
            String pizzaName = pizza.getPizzaName();
            System.out.println(pizzaName);
        }

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "抽象工厂模式示例");
        return build;
    }

    /**
     * 建造者模式
     */
    @RequestMapping(value = "/builderPattern")
    public Result<String> builderPattern() {
        AbsBuilder builder = new BBuilder();
        DecrorateHouse house = builder.getHouse();
        System.out.println(String.format("house:%s", JSON.toJSONString(house)));

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "建造者模式");
        return build;
    }

    /**
     * 单例模式
     */
    @RequestMapping(value = "/singtonPattern")
    public Result<String> singtonPattern() {
        ProjConstants instance = ProjConstants.getInstance();
        System.out.println(String.format("ProjConstants实例:%s", JSON.toJSONString(instance)));

        Result<String> build = super.buildReslt(ResultCode.SUCCESSEXT, "单例模式");
        return build;
    }

    /**
     * 原型模式
     */
    @RequestMapping(value = "/prototypePattern")
    public Result<String> prototypePattern() {
        Result<String> build = null;
        try {
            Thing thing = new Thing();
            Object clone = thing.clone();

            build = super.buildReslt(ResultCode.SUCCESSEXT, "原型模式");
        } catch (Exception ex) {
            build = super.buildReslt(ResultCode.FAIL, "原型模式");
        }

        return build;
    }
}
