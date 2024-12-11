package com.dfliu.patterns.service.interpreterplus;

import com.dfliu.patterns.domain.constants.Compare;

/**
 * 终结符表达式
 */
public class TerminalExpression implements Expression {

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 身高
     */
    private Double height;

    /**
     * 比较器
     */
    private final Compare compare;

    /**
     * 构造年龄比较
     * @param age 年龄
     * @param compare 比较器
     */
    public TerminalExpression(int age, Compare compare) {
        this.age = age;
        this.compare = compare;
    }

    /**
     * 构造身高比较
     * @param height 身高
     * @param compare 比较器
     */
    public TerminalExpression(double height, Compare compare) {
        this.height = height;
        this.compare = compare;
    }

    @Override
    public boolean interpret(int age) {

        // 比较年龄大小
        switch (compare) {
            // 较大
            case GT:
                return age > this.age;
            // 相等
            case EQ:
                return age == this.age;
            // 较小
            case LT:
                return age < this.age;
            default:
                return false;
        }
    }

    @Override
    public boolean interpret(double height) {

        // 比较身高大小
        switch (compare) {
            // 较大
            case GT:
                return height > this.height;
            // 相等
            case EQ:
                return height == this.height;
            // 较小
            case LT:
                return height < this.height;
            default:
                return false;
        }
    }

}
