package com.dfliu.patterns.service.binaryTree;

import com.dfliu.patterns.domain.dto.TreeNode;

/**
 * 二叉树类
 */
public class BinaryTree {
    private TreeNode<Integer> head = null;

    /**
     * 初始化二叉树
     */
    public void initTree() {
        TreeNode<Integer> node01 = new TreeNode<>(1);
        TreeNode<Integer> node02 = new TreeNode<>(2);
        TreeNode<Integer> node03 = new TreeNode<>(3);
        TreeNode<Integer> node04 = new TreeNode<>(4);
        TreeNode<Integer> node05 = new TreeNode<>(5);
        TreeNode<Integer> node06 = new TreeNode<>(6);
        TreeNode<Integer> node07 = new TreeNode<>(7);

        node01.setLeft(node02);
        node02.setLeft(node04);
        node02.setRight(node05);
        node01.setRight(node03);
        node03.setLeft(node06);
        node03.setRight(node07);

        //设置二叉树的头指针
        this.head = node01;
    }

    public void showTree(TreeNode<Integer> node) {
        //todo
    }
}
