package com.dfliu.patterns.service.binaryTree;

import com.dfliu.patterns.domain.dto.TreeNode;

/**
 * AVL树的相关操作
 */
public class AVLTree {
    public Integer getHeight(TreeNode<Integer> node) {
        return (null == node) ? -1 : node.getHeight();
    }

    public void updateHeight(TreeNode<Integer> node) {
        Integer height = Math.max(this.getHeight(node.getLeft()), this.getHeight(node.getRight())) + 1;
        node.setHeight(height);
    }

    /**
     * 获取平衡因子
     *
     * @param node
     * @return
     */
    public Integer getBalanceFactor(TreeNode<Integer> node) {
        if (null == node) {
            return 0;
        }
        return this.getHeight(node.getLeft()) - this.getHeight(node.getRight());
    }

    /**
     * 右旋操作
     *
     * @param node
     * @return
     */
    public TreeNode<Integer> rightRotate(TreeNode<Integer> node) {
        TreeNode<Integer> child = node.getLeft();
        TreeNode<Integer> grandChild = child.getRight();
        child.setRight(node);
        node.setLeft(grandChild);
        this.updateHeight(node);
        this.updateHeight(child);

        return child;
    }
}