package com.dfliu.patterns.service.visitor;

public class CommonEmployee extends Employee {
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    private String jobName;

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
