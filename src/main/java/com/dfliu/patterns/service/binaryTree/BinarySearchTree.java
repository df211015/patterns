package com.dfliu.patterns.service.binaryTree;

import com.dfliu.patterns.domain.dto.TreeNode;

/**
 * 二叉搜索树: 左子数节点值 < 根节点值 < 右子数节点值
 */
public class BinarySearchTree {
    private TreeNode<Integer> root;

    /**
     * 搜索指定节点
     *
     * @param data
     * @return
     */
    public TreeNode search(Integer data) {
        TreeNode<Integer> cur = this.root;
        while (null != cur) {
            if (cur.getData() < data) {
                cur = cur.getRight();
            } else if (cur.getData() > data) {
                cur = cur.getLeft();
            } else {
                break;
            }
        }

        return cur;
    }

    /**
     * 插入节点
     *
     * @param data
     */
    public void insert(Integer data) {
        if (null == this.root) {
            this.root = new TreeNode<Integer>(data);
            return;
        }
        TreeNode<Integer> cur = this.root;
        TreeNode<Integer> pre = null;
        while (null != cur) {
            if (cur.getData().equals(data)) {
                System.out.println(String.format("节点值:%s已存在", data));
                return;
            }
            pre = cur;
            if (cur.getData() < data) {
                cur = cur.getRight();
            } else {
                cur = cur.getLeft();
            }
        }

        TreeNode<Integer> node = new TreeNode<>(data);
        if (pre.getData() < data) {
            pre.setRight(node);
        } else {
            pre.setLeft(node);
        }
    }
}
