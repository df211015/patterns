package com.dfliu.patterns.domain.constants;

public enum EState {
    CHILD(1, "孩子"),
    ADULT(2, "成年人"),
    OLD(3, "老年人"),
    ;

    private Integer code;
    private String name;

    EState(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
