package com.dfliu.patterns.service.mediator;

public class ConcreteMediator extends Mediator {

    @Override
    public void dosomething1() {
        super.concreteColleague1.dosomethingOfOuter();
    }

    @Override
    public void dosomething2() {
        super.concreteColleague2.dosomethingOfOuter();
    }
}
