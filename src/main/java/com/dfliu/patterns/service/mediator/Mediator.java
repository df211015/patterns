package com.dfliu.patterns.service.mediator;

public abstract class Mediator {
    public void setConcreteColleague1(Colleague concreteColleague1) {
        this.concreteColleague1 = concreteColleague1;
    }

    public void setConcreteColleague2(Colleague concreteColleague2) {
        this.concreteColleague2 = concreteColleague2;
    }

    protected Colleague concreteColleague1;
    protected Colleague concreteColleague2;

    public abstract void dosomething1();

    public abstract void dosomething2();
}