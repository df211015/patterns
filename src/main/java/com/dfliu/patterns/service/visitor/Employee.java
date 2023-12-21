package com.dfliu.patterns.service.visitor;

public abstract class Employee {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getDesc() {
        return desc;
    }

    public void setDesc(Integer desc) {
        this.desc = desc;
    }

    public String userName;
    private Integer salary;
    private Integer desc;

    /**
     * 定义访问者方法
     *
     * @param visitor
     */
    public abstract void accept(IVisitor visitor);
}
