package com.dfliu.patterns.service.bridge;

public class ConcreteImplementor implements Implementor {

    @Override
    public void doSomething() {
        System.out.println("ConcreteImplementor -> doSomething");
    }

    @Override
    public void doAnything() {
        System.out.println("ConcreteImplementor -> doAnything");
    }
}