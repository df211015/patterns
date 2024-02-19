package com.dfliu.patterns.service.visitor.plus;

import java.util.ArrayList;
import java.util.List;

public class CompoundShape implements Shape {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;
    private List<Shape> children = new ArrayList<>();

    public CompoundShape(Integer id) {
        this.id = id;
    }

    @Override
    public void move(Integer x, Integer y) {

    }

    @Override
    public void draw() {

    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCompoundGraphic(this);
    }

    public void add(Shape shape) {
        this.children.add(shape);
    }
}
