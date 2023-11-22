package com.dfliu.patterns.service.state;

import com.dfliu.patterns.domain.constants.EState;

public class ChildWorkState extends WorkState {
    @Override
    public void workState() {
        System.out.println("child的工作状态");
        super.getContext().setCurrentByState(EState.ADULT);
    }
}