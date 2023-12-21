package com.dfliu.patterns.service.binaryTree;

import com.dfliu.patterns.domain.dto.TreeNode;

/**
 * AVL树的相关操作
 */
public class AVLTree {

    private TreeNode<Integer> root;

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
     * @param node 失衡节点
     * @return 返回调整后的局部子树根节点
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

    /**
     * 左旋操作
     *
     * @param node 失衡节点
     * @return 返回调整后的局部子树根节点
     */
    public TreeNode<Integer> leftRotate(TreeNode<Integer> node) {
        TreeNode<Integer> child = node.getRight();
        TreeNode<Integer> grandChild = child.getLeft();
        child.setLeft(node);
        node.setRight(grandChild);
        this.updateHeight(node);
        this.updateHeight(child);

        return child;
    }

    /**
     * 执行旋转操作,使该子树重新恢复平衡
     *
     * @param node
     * @return
     */
    public TreeNode<Integer> rotate(TreeNode<Integer> node) {
        Integer balanceFactor = this.getBalanceFactor(node);
        //左偏树
        if (balanceFactor > 1) {
            if (this.getBalanceFactor(node.getLeft()) >= 0) {
                return this.rightRotate(node);
            } else {
                TreeNode<Integer> integerTreeNode = this.leftRotate(node.getLeft());
                node.setLeft(integerTreeNode);
                return this.rightRotate(node);
            }
        }
        //右偏树
        if (balanceFactor < -1) {
            if (this.getBalanceFactor(node.getRight()) <= 0) {
                return this.leftRotate(node);
            } else {
                TreeNode<Integer> integerTreeNode = this.rightRotate(node.getRight());
                node.setRight(integerTreeNode);
                return this.leftRotate(node);
            }
        }

        return node;
    }

    public void insert(Integer val) {
        this.root = this.insertHelper(this.root, val);
    }

    public void remove(Integer val) {
        this.root = this.removeHelper(this.root, val);
    }

    private TreeNode insertHelper(TreeNode<Integer> node, Integer val) {
        if (null == node) {
            return new TreeNode<Integer>(val);
        }
        if (val < node.getData()) {
            TreeNode<Integer> treeNodeOfLeft = this.insertHelper(node.getLeft(), val);
            node.setLeft(treeNodeOfLeft);
        } else if (val > node.getData()) {
            TreeNode<Integer> treeNodeOfRight = this.insertHelper(node.getRight(), val);
            node.setRight(treeNodeOfRight);
        } else {
            return node;
        }
        this.updateHeight(node);
        node = this.rotate(node);

        return node;
    }

    private TreeNode<Integer> removeHelper(TreeNode<Integer> node, Integer val) {
        return null;
    }
}