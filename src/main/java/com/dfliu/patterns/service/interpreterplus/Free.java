package com.dfliu.patterns.service.interpreterplus;

import com.dfliu.patterns.domain.constants.Compare;

/**
 * 免费标准
 */
public class Free {

    /**
     * 年龄表达式
     */
    private Expression ageExpression;

    /**
     * 身高表达式
     */
    private Expression heightExpression;

    /**
     * 构造免费情况
     *
     * @param age    年龄
     * @param height 身高
     */
    public Free(int age, double height) {
        //大于等于设定年龄
        Expression expression1 = new TerminalExpression(age, Compare.GT);
        Expression expression2 = new TerminalExpression(age, Compare.EQ);
        ageExpression = new OrExpression(expression1, expression2);
        //小于等于设定身高
        expression1 = new TerminalExpression(height, Compare.LT);
        expression2 = new TerminalExpression(height, Compare.EQ);
        heightExpression = new OrExpression(expression1, expression2);
    }

    /**
     * 结果
     *
     * @param age    年龄
     * @param height 身高
     * @return 判定结果
     */
    public boolean result(int age, double height) {
        return ageExpression.interpret(age) || heightExpression.interpret(height);
    }
}
