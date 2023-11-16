package com.dfliu.patterns.domain.dto;

import lombok.Data;

@Data
public class Pair {
    private Integer key;
    private String val;

    public Pair(Integer key, String val) {
        this.key = key;
        this.val = val;
    }
}
