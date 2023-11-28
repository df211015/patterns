package com.dfliu.patterns.service.command;

public class ConcreteCommand extends AbsCommand {

    public ConcreteCommand(IReceive receive) {
        super(receive);
    }

    @Override
    public void order(String param) {
        this.before(param);
        super.getReceive().doSomething(param);
    }

    private void before(String param) {
        System.out.println(String.format("concreteCommand.before:%s", param));
    }
}
