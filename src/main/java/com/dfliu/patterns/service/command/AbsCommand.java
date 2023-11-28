package com.dfliu.patterns.service.command;

public abstract class AbsCommand {
    private IReceive receive;

    public IReceive getReceive() {
        return receive;
    }

    public AbsCommand(IReceive receive) {
        this.receive = receive;
    }

    public abstract void order(String param);
}