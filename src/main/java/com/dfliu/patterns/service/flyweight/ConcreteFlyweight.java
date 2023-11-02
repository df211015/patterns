package com.dfliu.patterns.service.flyweight;

public class ConcreteFlyweight implements IFlyweight {
    private String key;

    protected ConcreteFlyweight(String key) {
        this.key = key;
        System.out.println(String.format("具体享元:%s,被创建！", key));
    }

    @Override
    public void operation(UnsharedConcreteFlyweight state) {
        System.out.println(String.format("具体享元:%s,被调用,非享元信息是:%s", this.key, state.getInfo()));
    }
}
