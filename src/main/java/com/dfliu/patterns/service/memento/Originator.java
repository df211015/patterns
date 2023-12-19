package com.dfliu.patterns.service.memento;

public class Originator {
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private String data;

    public Memento createMemento() {
        return new Memento(this.getData());
    }

    public void restoreMemento(Memento memento) {
        this.setData(memento.getData());
    }
}
