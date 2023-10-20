package com.dfliu.patterns.domain.dto;

import lombok.Data;

@Data
public abstract class Bread {
    private String name;

    public Bread(String name) {
        this.name = name;
    }

    public abstract String getBreadName();
}
