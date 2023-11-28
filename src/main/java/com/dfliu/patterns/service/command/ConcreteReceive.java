package com.dfliu.patterns.service.command;

public class ConcreteReceive implements IReceive {
    @Override
    public void doSomething(String param) {
        System.out.println(String.format("concreteReceive:%s", param));
    }
}
