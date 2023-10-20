package com.dfliu.patterns.domain.dto;

public class WhiteBread extends Bread {
    public WhiteBread(String name) {
        super(name);
    }

    @Override
    public String getBreadName() {
        return String.format("breadName:%s,in the WhiteBread", super.getName());
    }
}
