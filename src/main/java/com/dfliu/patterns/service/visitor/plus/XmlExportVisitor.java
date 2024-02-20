package com.dfliu.patterns.service.visitor.plus;

import java.util.List;

public class XmlExportVisitor implements Visitor {

    /**
     * 导出元素
     *
     * @param args
     * @return
     */
    public String export(List<Shape> args) {
        StringBuilder sb = new StringBuilder();
        for (Shape shape : args) {
            sb.append(shape.accept(this)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String visitDot(Dot dot) {
        return String.format("dot,id:%s,x:%s,y:%s", dot.getId(), dot.getX(), dot.getY());
    }

    @Override
    public String visitCircle(Circle circle) {
        return String.format("circle,id:%s,x:%s,y:%s,radius:%s", circle.getId(), circle.getX(), circle.getY(), circle.getRadius());
    }

    @Override
    public String visitRectangle(Rectangle rectangle) {
        return String.format("rectangle,id:%s,width:%s,height:%s", rectangle.getId(), rectangle.getWidth(), rectangle.getHeight());
    }

    @Override
    public String visitCompoundGraphic(CompoundShape cg) {
        return String.format("visitCompoundGraphic,id:%s", cg.getId());
    }
}
