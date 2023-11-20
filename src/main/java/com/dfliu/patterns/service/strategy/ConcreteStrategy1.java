package com.dfliu.patterns.service.strategy;

public class ConcreteStrategy1 implements Strategy {

    @Override
    public void doSomething() {
        System.out.println("ConcreteStrategy1 -> doSomething");
    }
}