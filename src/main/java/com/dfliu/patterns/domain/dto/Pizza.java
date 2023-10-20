package com.dfliu.patterns.domain.dto;

import lombok.Data;

@Data
public abstract class Pizza {
    private String name;

    public Pizza(String name) {
        this.name = name;
    }

    public abstract String getPizzaName();
}