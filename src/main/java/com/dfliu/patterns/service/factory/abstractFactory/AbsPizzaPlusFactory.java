package com.dfliu.patterns.service.factory.abstractFactory;

import com.dfliu.patterns.domain.dto.Bread;
import com.dfliu.patterns.domain.dto.Pizza;

public abstract class AbsPizzaPlusFactory {
    public abstract Pizza createdPizza();

    public abstract Bread createBread();
}
