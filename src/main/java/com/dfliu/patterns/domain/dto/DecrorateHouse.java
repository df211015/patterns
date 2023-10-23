package com.dfliu.patterns.domain.dto;

import lombok.Data;

@Data
public class DecrorateHouse {
    /**
     * 储物柜
     */
    private String closet;

    /**
     * 阳台
     */
    private String balcony;

    /**
     * 卧室
     */
    private String bedroom;
}
