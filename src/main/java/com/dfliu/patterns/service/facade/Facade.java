package com.dfliu.patterns.service.facade;

public class Facade {
    private ClassA classA = new ClassA();
    private ClassB classB = new ClassB();
    private ClassC classC = new ClassC();

    /**
     * 门面模式示例
     */
    public void doSomething() {
        this.classA.doA();
        this.classB.doB();
        this.classC.doC();
    }
}
