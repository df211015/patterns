package com.dfliu.patterns.domain.dto;

public class CheesePizza extends Pizza {
    public CheesePizza(String name) {
        super(name);
    }

    @Override
    public String getPizzaName() {
        return String.format("pizzaName:%s,in the CheesePizza", super.getName());
    }
}
