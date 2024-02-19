package com.dfliu.patterns.service.visitor.plus;

import java.util.List;

public class XmlExportVisitor implements Visitor {

    public String export(List<Shape> args) {
        return null;
    }

    @Override
    public String visitDot(Dot dot) {
        return String.format("dot,id:%s,x:%s,y:%s", dot.getId(), dot.getX(), dot.getY());
    }

    @Override
    public String visitCircle(Circle circle) {
        return String.format("circle,id:%s,x:%s,y:%s,radius:%s", circle.getId(), circle.getX(), circle.getY());
    }

    @Override
    public String visitRectangle(Rectangle rectangle) {
        return String.format("rectangle,id:%s,width:%s,height", rectangle.getId(), rectangle.getWidth(), rectangle.getHeight());
    }

    @Override
    public String visitCompoundGraphic(CompoundShape cg) {
        return String.format("visitCompoundGraphic,id:%s", cg.getId());
    }
}
