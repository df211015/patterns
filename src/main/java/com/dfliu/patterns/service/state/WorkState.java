package com.dfliu.patterns.service.state;

public abstract class WorkState {
    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void workState();
}