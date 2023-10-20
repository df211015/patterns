package com.dfliu.patterns.service.factory.abstractFactory;

import com.dfliu.patterns.domain.dto.Bread;
import com.dfliu.patterns.domain.dto.CheesePizza;
import com.dfliu.patterns.domain.dto.Pizza;
import com.dfliu.patterns.domain.dto.WhiteBread;

public class CheesePizzaPlusFactory extends AbsPizzaPlusFactory {

    @Override
    public Pizza createdPizza() {
        return new CheesePizza("cheese");
    }

    @Override
    public Bread createBread() {
        return new WhiteBread("white");
    }
}
