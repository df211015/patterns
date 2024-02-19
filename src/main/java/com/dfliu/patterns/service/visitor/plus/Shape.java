package com.dfliu.patterns.service.visitor.plus;

public interface Shape {
    void move(Integer x, Integer y);
    void draw();
    String accept(Visitor visitor);
}
