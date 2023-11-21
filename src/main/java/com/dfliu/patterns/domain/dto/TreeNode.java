package com.dfliu.patterns.domain.dto;

import lombok.Data;

@Data
public class TreeNode<T> {
    private T data;
    private TreeNode<T> left;
    private TreeNode<T> right;
}
