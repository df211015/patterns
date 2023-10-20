package com.dfliu.patterns.domain.dto;

public class BlackBread extends Bread {
    public BlackBread(String name) {
        super(name);
    }

    @Override
    public String getBreadName() {
        return String.format("breadName:%s,in the BlackBread", super.getName());
    }
}
