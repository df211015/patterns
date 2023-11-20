package com.dfliu.patterns.service.strategy;

public class ConcreteStrategy2 implements Strategy {

    @Override
    public void doSomething() {
        System.out.println("ConcreteStrategy2 -> doSomething");
    }
}