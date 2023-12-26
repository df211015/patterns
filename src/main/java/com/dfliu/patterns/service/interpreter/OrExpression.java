package com.dfliu.patterns.service.interpreter;

public class OrExpression implements Expression {
    private Expression left;
    private Expression right;

    public OrExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean interpret(String context) {
        return this.left.interpret(context) || this.right.interpret(context);
    }
}
