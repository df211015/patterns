package com.dfliu.patterns.domain.dto;

import lombok.Data;

@Data
public class TreeNode<T> {
    //节点高度
    private Integer height;
    private T data;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
    }
}
