package com.dfliu.patterns.domain.dto;

public class PepperPizza extends Pizza {

    public PepperPizza(String name) {
        super(name);
    }

    @Override
    public String getPizzaName() {
        return String.format("pizzaName:%s,in the PepperPizza", super.getName());
    }
}
