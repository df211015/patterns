package com.dfliu.patterns.domain.constants;

public enum EPoolObjStatus {
    using(1,"使用中"),
    free(9,"空闲"),
    ;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Integer code;
    private String name;

    EPoolObjStatus(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
