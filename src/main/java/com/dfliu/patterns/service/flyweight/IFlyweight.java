package com.dfliu.patterns.service.flyweight;

public interface IFlyweight {
    void operation(UnsharedConcreteFlyweight state);
}