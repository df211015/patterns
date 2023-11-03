package com.dfliu.patterns.service.bridge;

public abstract class Abstraction {
    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public void request() {
        this.implementor.doSomething();
    }
}
