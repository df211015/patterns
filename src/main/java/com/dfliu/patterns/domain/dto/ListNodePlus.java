package com.dfliu.patterns.domain.dto;

import lombok.Data;

@Data
public class ListNodePlus<T> {
    private T data;
    private ListNodePlus<T> next;
    private ListNodePlus<T> pre;
}