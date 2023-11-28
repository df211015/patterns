package com.dfliu.patterns.service.binaryTree;

import com.dfliu.patterns.domain.dto.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 二叉树类
 */
public class BinaryTreeOfLink {
    private TreeNode<Integer> head = null;

    public TreeNode<Integer> getHead() {
        return head;
    }

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
        TreeNode<Integer> node08 = new TreeNode<>(8);

        node01.setLeft(node02);
        node02.setLeft(node04);
        node02.setRight(node05);
        node01.setRight(node03);
        node03.setLeft(node06);
        node03.setRight(node07);
        node04.setLeft(node08);

        //设置二叉树的头指针
        this.head = node01;
    }

    /**
     * 前序遍历
     *
     * @param node
     */
    public void preOrderTraversal(TreeNode<Integer> node) {
        if (null != node) {
            System.out.println(String.format("node.data=%s", node.getData()));
            this.preOrderTraversal(node.getLeft());
            this.preOrderTraversal(node.getRight());
        }
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public void midOrderTraversal(TreeNode<Integer> node) {
        if (null != node) {
            this.midOrderTraversal(node.getLeft());
            System.out.println(String.format("node.data=%s", node.getData()));
            this.midOrderTraversal(node.getRight());
        }
    }

    public void postOrderTraversal(TreeNode<Integer> node) {
        if (null != node) {
            this.postOrderTraversal(node.getLeft());
            this.postOrderTraversal(node.getRight());
            System.out.println(String.format("node.data=%s", node.getData()));
        }
    }

    /**
     * 层序遍历
     *
     * @param node
     * @return
     */
    public List<Integer> levelOrderTraversal(TreeNode<Integer> node) {
        List<Integer> lstValue = new ArrayList<>();
        Queue<TreeNode<Integer>> queue = new ConcurrentLinkedQueue<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode<Integer> nodeTmp = queue.poll();
            lstValue.add(nodeTmp.getData());
            System.out.println(String.format("node.data:%s", nodeTmp.getData()));
            if (null != nodeTmp.getLeft()) {
                queue.add(nodeTmp.getLeft());
            }
            if (null != nodeTmp.getRight()) {
                queue.add(nodeTmp.getRight());
            }
        }

        return lstValue;
    }
}
