package com.dfliu.patterns.service.proxy;

public class GuoWorker implements IDecorate {
    @Override
    public void decorate(String operator) {
        System.out.println("郭师傅开始装修中...");
    }
}
