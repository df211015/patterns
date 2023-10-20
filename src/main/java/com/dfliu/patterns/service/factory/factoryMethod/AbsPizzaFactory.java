package com.dfliu.patterns.service.factory.factoryMethod;

import com.dfliu.patterns.domain.dto.Pizza;

public abstract class AbsPizzaFactory {
    public abstract Pizza createPizza();
}