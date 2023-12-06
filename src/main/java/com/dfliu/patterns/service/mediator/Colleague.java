package com.dfliu.patterns.service.mediator;

public abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void dosomething();

    /**
     *
     */
    public abstract void dosomethingOfOuter();
}
