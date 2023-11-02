package com.dfliu.patterns.service.flyweight;

import java.util.HashMap;

public class FlyweightFactory {
    private HashMap<String, IFlyweight> flyweights = new HashMap<>();

    public IFlyweight getFlyweight(String key) {
        IFlyweight flyweight = this.flyweights.get(key);
        if (null != flyweight) {
            System.out.println(String.format("具体享元:%s,已经存在，被成功获取!", key));
        } else {
            flyweight = new ConcreteFlyweight(key);
            this.flyweights.put(key, flyweight);
        }

        return flyweight;
    }
}
