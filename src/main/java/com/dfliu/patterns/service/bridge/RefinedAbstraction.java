package com.dfliu.patterns.service.bridge;

public class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void request() {
        super.request();
        super.implementor.doAnything();
    }
}
