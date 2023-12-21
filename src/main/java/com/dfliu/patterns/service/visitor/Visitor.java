package com.dfliu.patterns.service.visitor;

public class Visitor implements IVisitor {
    @Override
    public void visit(CommonEmployee item) {
        String info = this.getCommonEmployee(item);
        System.out.println(info);
    }

    @Override
    public void visit(Manager item) {
        String info = this.getManager(item);
        System.out.println(info);
    }

    private String getCommonEmployee(CommonEmployee item) {
        if (null != item) {
            return String.format("userName:%s,salary:%s,desc:%s,jobName:%s",
                    item.getUserName(),
                    item.getSalary(),
                    item.getDesc(),
                    item.getJobName());
        }
        return null;
    }

    private String getManager(Manager item) {
        if (null != item) {
            return String.format("userName:%s,salary:%s,desc:%s,perfomance:%s",
                    item.getUserName(),
                    item.getSalary(),
                    item.getDesc(),
                    item.getPerformance());
        }
        return null;
    }
}
