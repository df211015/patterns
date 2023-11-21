package com.dfliu.patterns.service.chain;

public abstract class Handler {
    private Integer requestType;
    private Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public Handler(Integer requestType) {
        this.requestType = requestType;
    }

    public void handler(IWomen women) {
        if (this.requestType.equals(women.getType())) {
            this.response(women);
        } else {
            if (null != this.nextHandler) {
                this.handler(women);
            } else {
                System.out.println("没有相应的处理类!");
            }
        }
    }

    public abstract void response(IWomen women);
}
