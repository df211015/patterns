package com.dfliu.patterns.service.adapter;

public class Adapter implements ITarget {

    public IAdaptee getAdaptee() {
        return adaptee;
    }

    public void setAdaptee(IAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    private IAdaptee adaptee;

    @Override
    public void targetObj() {
        this.convert();
        System.out.println("适配ITarget接口完成");
    }

    private void convert() {
        System.out.println("处理IAdaptee对像");
    }
}
