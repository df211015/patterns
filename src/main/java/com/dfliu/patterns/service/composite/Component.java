package com.dfliu.patterns.service.composite;

public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void add(Component v);

    public abstract void remove(Component v);

    public abstract void display(Integer depth);
}