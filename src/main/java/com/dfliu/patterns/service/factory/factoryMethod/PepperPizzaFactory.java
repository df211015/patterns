package com.dfliu.patterns.service.factory.factoryMethod;

import com.dfliu.patterns.domain.dto.PepperPizza;
import com.dfliu.patterns.domain.dto.Pizza;

public class PepperPizzaFactory extends AbsPizzaFactory {
    @Override
    public Pizza createPizza() {
        return new PepperPizza("pepper");
    }
}