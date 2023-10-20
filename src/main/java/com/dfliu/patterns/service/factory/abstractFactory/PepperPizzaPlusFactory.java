package com.dfliu.patterns.service.factory.abstractFactory;

import com.dfliu.patterns.domain.dto.BlackBread;
import com.dfliu.patterns.domain.dto.Bread;
import com.dfliu.patterns.domain.dto.PepperPizza;
import com.dfliu.patterns.domain.dto.Pizza;

public class PepperPizzaPlusFactory extends AbsPizzaPlusFactory {
    @Override
    public Pizza createdPizza() {
        return new PepperPizza("pepper");
    }

    @Override
    public Bread createBread() {
        return new BlackBread("black");
    }
}
