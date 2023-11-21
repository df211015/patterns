package com.dfliu.patterns.domain.constants;

public enum ResponseType {
    SON(1, "儿子的响应"),
    HUSBAND(2, "丈夫的响应"),
    FATHER(3, "父亲的响应"),
    OTHER(4, "其他角色"),
    ;

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    private Integer code;
    private String name;

    ResponseType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
