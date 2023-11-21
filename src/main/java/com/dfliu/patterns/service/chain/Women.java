package com.dfliu.patterns.service.chain;

public class Women implements IWomen {
    private Integer type;

    private String request;

    public Women(Integer type, String request) {
        this.type = type;
        switch (this.type) {
            case 1:
                this.request = String.format("女儿的请求是:%s", request);
                break;
            case 2:
                this.request = String.format("妻子的请求是:%s", request);
                break;
            case 3:
                this.request = String.format("母亲的请求是:%s", request);
                break;
        }

    }

    @Override
    public Integer getType() {
        return this.type;
    }

    @Override
    public String getRequest() {
        return this.request;
    }
}
