package com.dfliu.patterns.service.prototype;

import java.util.ArrayList;
import java.util.List;

public class Thing implements Cloneable {

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<String> getLst() {
        return lst;
    }

    public void setLst(List<String> lst) {
        this.lst = lst;
    }

    private String value;

    private List<String> lst = new ArrayList<>();

    @Override
    public Object clone() throws CloneNotSupportedException {
        Thing thing = (Thing) super.clone();
        return thing;
    }
}
