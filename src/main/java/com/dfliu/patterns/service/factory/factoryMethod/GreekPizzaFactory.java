package com.dfliu.patterns.service.factory.factoryMethod;

import com.dfliu.patterns.domain.dto.GreekPizza;
import com.dfliu.patterns.domain.dto.Pizza;

public class GreekPizzaFactory extends AbsPizzaFactory {
    @Override
    public Pizza createPizza() {
        return new GreekPizza("greek");
    }
}
