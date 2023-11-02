package com.dfliu.patterns.service.flyweight;

public class UnsharedConcreteFlyweight {
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private String info;

    public UnsharedConcreteFlyweight(String info) {
        this.info = info;
    }
}
