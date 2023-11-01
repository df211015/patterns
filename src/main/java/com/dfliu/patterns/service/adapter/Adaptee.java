package com.dfliu.patterns.service.adapter;

public class Adaptee implements IAdaptee {

    @Override
    public void adapteeObj() {
        System.out.println("构建Adaptee对像");
    }
}
