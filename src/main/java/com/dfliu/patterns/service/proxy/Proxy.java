package com.dfliu.patterns.service.proxy;

public class Proxy implements IDecorate {
    private IDecorate decorate;

    public Proxy(IDecorate decorate) {
        this.decorate = decorate;
    }

    private void before(String operator) {
        System.out.println(String.format("%s进场,装修前...", operator));
    }

    private void after(String operator) {
        System.out.println(String.format("%s离场,装修结束", operator));
    }

    @Override
    public void decorate(String operator) {
        this.before(operator);
        this.decorate.decorate(operator);
        this.after(operator);
    }
}
