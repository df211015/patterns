package com.dfliu.patterns.service.visitor;

public class Manager extends Employee {
    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    private String performance;

    @Override
    public void accept(IVisitor visitor) {
        if (null == visitor) {
            return;
        }
        visitor.visit(this);
    }
}
