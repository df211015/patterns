package com.dfliu.patterns.domain.dto;

import lombok.Data;

@Data
public class ListNode<T> {
    private T data;
    private ListNode<T> next;
}