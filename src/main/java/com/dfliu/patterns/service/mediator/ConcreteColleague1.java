package com.dfliu.patterns.service.mediator;

public class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void dosomething() {
        System.out.println("ConcreteColleague1 --> dosomething");
        super.mediator.dosomething2();
    }

    @Override
    public void dosomethingOfOuter() {
        System.out.println("ConcreteColleague1 --> dosomethingOfOuter");
    }
}
