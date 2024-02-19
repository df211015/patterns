package com.dfliu.patterns.service.visitor.plus;

public class Circle extends Dot {
    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    private Integer radius;

    public Circle(Integer id, Integer x, Integer y, Integer radius) {
        super(id, x, y);
        this.radius = radius;
    }

    @Override
    public String accept(Visitor visitor) {
        return null;
    }
}
