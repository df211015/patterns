package com.dfliu.patterns.service.visitor;

public interface IVisitor {
    void visit(CommonEmployee item);

    void visit(Manager item);
}
