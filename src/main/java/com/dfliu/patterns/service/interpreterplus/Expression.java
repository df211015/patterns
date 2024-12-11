package com.dfliu.patterns.service.interpreterplus;

/**
 * 表达式
 */
public interface Expression {

    /**
     * 解释年龄
     *
     * @param age 年龄
     * @return 解释结果
     */
    boolean interpret(int age);

    /**
     * 解释身高
     *
     * @param height 身高
     * @return 解释结果
     */
    boolean interpret(double height);
}