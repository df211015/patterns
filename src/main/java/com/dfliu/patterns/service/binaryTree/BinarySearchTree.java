package com.dfliu.patterns.service.binaryTree;

import com.dfliu.patterns.domain.dto.TreeNode;
import lombok.val;

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
     * 插入节点,只会以叶子节点的形式插入
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

    /**
     * 删除节点
     *
     * @param data
     * @return
     */
    public void remove(Integer data) {
        TreeNode<Integer> pre = null;
        TreeNode<Integer> cur = this.root;
        while (null != cur) {
            pre = cur;
            if (cur.getData().equals(data)) {
                break;
            }
            if (cur.getData() < data) {
                cur = cur.getRight();
            } else {
                cur = cur.getLeft();
            }
        }
        if (null == cur) {
            return;
        }
        Integer degree = this.getDegree(cur);
        //当被删除的节点度为0或1时
        if (degree.equals(0) || degree.equals(1)) {
            TreeNode<Integer> child = (null != cur.getLeft()) ? cur.getLeft() : cur.getRight();
            if (cur.equals(this.root)) {
                this.root = child;
            } else {
                if (pre.getLeft().equals(cur)) {
                    pre.setLeft(child);
                } else {
                    pre.setRight(child);
                }
            }
        } else if (degree.equals(2)) {
            //当被删除的节点度为2时,获取中序遍历中,cur的下一个节点
            TreeNode<Integer> tmp = cur.getRight();
            while (null != tmp.getLeft()) {
                tmp = tmp.getLeft();
            }
            this.remove(tmp.getData());
            cur.setData(tmp.getData());
        }
    }

    /**
     * 获取指定节点的度
     *
     * @param node
     * @return
     */
    private Integer getDegree(TreeNode<Integer> node) {
        if (null == node.getLeft() && null == node.getRight()) {
            return 0;
        } else if (null == node.getLeft() || null == node.getRight()) {
            return 1;
        } else {
            return 2;
        }
    }
}
