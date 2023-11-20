package com.dfliu.patterns.service.strategy;

public class Context {
    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    private Strategy strategy;

    /**
     * 按具体策略执行业务逻辑
     */
    public void doSomething() {
        if (null != this.strategy) {
            this.strategy.doSomething();
        }
    }
}
