package com.dfliu.patterns.service.state;

import com.dfliu.patterns.domain.constants.EState;

import java.util.HashMap;
import java.util.Map;

public class Context {
    private final WorkState childWorkState = new ChildWorkState();
    private final WorkState adultWorkState = new AdultWorkState();
    private final WorkState oldWorkState = new OldWorkState();
    private final Map<EState, WorkState> initStateMap = new HashMap<>();
    private WorkState currentState;

    public Context() {
        this.initStateMap.put(EState.CHILD, this.childWorkState);
        this.initStateMap.put(EState.ADULT, this.adultWorkState);
        this.initStateMap.put(EState.OLD, this.oldWorkState);
    }

    public WorkState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(WorkState currentState) {
        if (null == currentState) {
            return;
        }
        this.currentState = currentState;
        this.currentState.setContext(this);
    }

    public void setCurrentByState(EState state) {
        WorkState workState = this.initStateMap.get(state);
        if (null != workState) {
            this.setCurrentState(workState);
        }
    }

    public void work() {
        if (null == this.currentState) {
            System.out.println("未找到处理类!");
        }

        this.currentState.workState();
    }
}