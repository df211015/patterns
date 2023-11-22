package com.dfliu.patterns.service.state;

public class OldWorkState extends WorkState {
    @Override
    public void workState() {
        System.out.println("old的工作状态");
        super.getContext().setCurrentState(null);
    }
}