package com.dfliu.patterns.service.factory.factoryMethod;

import com.dfliu.patterns.domain.dto.CheesePizza;
import com.dfliu.patterns.domain.dto.Pizza;

public class CheesePizzaFactory extends AbsPizzaFactory {

    @Override
    public Pizza createPizza() {
        return new CheesePizza("cheese");
    }
}