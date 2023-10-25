package com.dfliu.patterns;

import com.alibaba.fastjson.JSON;
import com.dfliu.patterns.domain.dto.Bread;
import com.dfliu.patterns.domain.dto.DecrorateHouse;
import com.dfliu.patterns.domain.dto.Pizza;
import com.dfliu.patterns.service.builder.AbsBuilder;
import com.dfliu.patterns.service.builder.BBuilder;
import com.dfliu.patterns.service.factory.abstractFactory.AbsPizzaPlusFactory;
import com.dfliu.patterns.service.factory.abstractFactory.CheesePizzaPlusFactory;
import com.dfliu.patterns.service.factory.factoryMethod.AbsPizzaFactory;
import com.dfliu.patterns.service.factory.factoryMethod.CheesePizzaFactory;
import com.dfliu.patterns.service.factory.simpleFactory.SimplePizzaFactory;
import com.dfliu.patterns.service.prototype.Thing;
import com.dfliu.patterns.service.singleton.ProjConstants;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatternsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PatternsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("启动成功!");

        /**
         * 简单工厂模式示例
         */
        Pizza pepper = SimplePizzaFactory.getInstanceOfPizza("pepper");
        if (null != pepper) {
            String pizzaName = pepper.getPizzaName();
            System.out.println(pizzaName);
        }

        /**
         * 工厂方法模式示例
         */
        AbsPizzaFactory pizzaFactory = new CheesePizzaFactory();
        Pizza cheesePizza = pizzaFactory.createPizza();
        if (null != cheesePizza) {
            String pizzaName = cheesePizza.getName();
            System.out.println(pizzaName);
        }

        /**
         * 抽象工厂模式示例
         */
        AbsPizzaPlusFactory cheesePizzaPlusFactory = new CheesePizzaPlusFactory();
        Pizza pizza = cheesePizzaPlusFactory.createdPizza();
        Bread bread = cheesePizzaPlusFactory.createBread();
        if (null != pizza) {
            String pizzaName = pizza.getPizzaName();
            System.out.println(pizzaName);
        }

        /**
         * 建造者模式
         */
        AbsBuilder builder = new BBuilder();
        DecrorateHouse house = builder.getHouse();
        System.out.println(String.format("house:%s", JSON.toJSONString(house)));

        /**
         * 单例模式
         */
        ProjConstants instance = ProjConstants.getInstance();
        System.out.println(String.format("ProjConstants实例:%s", JSON.toJSONString(instance)));

        /**
         * 原型模式
         */
        Thing thing = new Thing();
        Object clone = thing.clone();
    }
}
