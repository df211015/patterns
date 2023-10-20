package com.dfliu.patterns.domain.dto;

public class GreekPizza extends Pizza {
    public GreekPizza(String name) {
        super(name);
    }

    @Override
    public String getPizzaName() {
        return String.format("pizzaName:%s,in the getPizzaName", super.getName());
    }
}
