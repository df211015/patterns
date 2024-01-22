package com.dfliu.patterns.service.servant;

public class Service1 implements IServiced {
    @Override
    public void serviced() {
        System.out.println(String.format("雇工模式:%s", this.getClass().toString()));
    }
}
