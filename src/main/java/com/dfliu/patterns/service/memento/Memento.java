package com.dfliu.patterns.service.memento;

public class Memento {
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private String data;

    public Memento(String data) {
        this.data = data;
    }
}
