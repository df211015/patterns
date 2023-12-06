package com.dfliu.patterns.service.mediator;

public class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void dosomething() {
        System.out.println("ConcreteColleague2 --> dosomething");
        super.mediator.dosomething1();
    }

    @Override
    public void dosomethingOfOuter() {
        System.out.println("ConcreteColleague2 --> dosomethingOfOuter");
    }
}
