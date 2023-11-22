package com.dfliu.patterns.service.state;

import com.dfliu.patterns.domain.constants.EState;

public class AdultWorkState extends WorkState {
    @Override
    public void workState() {
        System.out.println("adult的工作状态");
        super.getContext().setCurrentByState(EState.OLD);
    }
}