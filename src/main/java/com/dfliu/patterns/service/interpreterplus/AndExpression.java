package com.dfliu.patterns.service.interpreterplus;

/**
 * 与表达式
 */
public class AndExpression implements Expression {

    /**
     * 表达式1
     */
    private Expression expression1;

    /**
     * 表达式2
     */
    private Expression expression2;

    /**
     * 构造表达式
     *
     * @param expression1 表达式1
     * @param expression2 表达式2
     */
    public AndExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(int age) {
        return this.expression1.interpret(age) && this.expression2.interpret(age);
    }

    @Override
    public boolean interpret(double height) {
        return this.expression1.interpret(height) && this.expression2.interpret(height);
    }
}
