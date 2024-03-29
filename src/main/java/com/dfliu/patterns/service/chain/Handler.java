package com.dfliu.patterns.service.chain;

public abstract class Handler {
    private Integer requestType;
    private Handler nextHandler;

    public Integer getOrderNo() {
        return orderNo;
    }

    private Integer orderNo;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public Handler(Integer requestType, Integer orderNo) {
        this.requestType = requestType;
        this.orderNo = orderNo;
    }

    public void handler(IWomen women) {
        if (this.requestType.equals(women.getType())) {
            this.response(women);
        } else {
            if (null != this.nextHandler) {
                //注意此处的调用对像,不要直接写成this.handler(women)
                this.nextHandler.handler(women);
            } else {
                System.out.println("没有相应的处理类!");
            }
        }
    }

    public abstract void response(IWomen women);
}
