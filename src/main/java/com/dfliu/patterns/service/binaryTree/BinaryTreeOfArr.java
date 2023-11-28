package com.dfliu.patterns.service.binaryTree;

import java.util.List;

public class BinaryTreeOfArr<T> {
    private List<T> tree;

    public BinaryTreeOfArr(List<T> arrItem) {
        this.tree = arrItem;
    }

    /**
     * @param index
     * @return
     */
    public T getValue(Integer index) {
        if (null != this.tree) {
            if (index < 0 || index >= this.tree.size()) {
                return null;
            }
            return this.tree.get(index);
        }

        return null;
    }

    /**
     * 获取数组中左结点对应的索引值
     *
     * @param index
     * @return
     */
    public Integer getLeftIndex(Integer index) {
        return 2 * index + 1;
    }

    /**
     * 获取数据中右结点对应的索引值
     *
     * @param index
     * @return
     */
    public Integer getRightIndex(Integer index) {
        return 2 * index + 2;
    }

    /**
     * 层序遍历
     */
    public void levelOrderTraversal() {
        this.tree.forEach(r -> {
            if (null != r) {
                System.out.println(String.format("item:%s", String.valueOf(r)));
            }
        });
    }

    /**
     * 前序遍历
     *
     * @param index
     */
    public void preOrderTraversal(Integer index) {
        if (null != this.getValue(index)) {
            System.out.println(String.format("item.value:%s", this.getValue(index)));
            this.preOrderTraversal(this.getLeftIndex(index));
            this.preOrderTraversal(this.getRightIndex(index));
        }
    }

    /**
     * 中序遍历
     *
     * @param index
     */
    public void midOrderTraversal(Integer index) {
        if (null != this.getValue(index)) {
            this.midOrderTraversal(this.getLeftIndex(index));
            System.out.println(String.format("item.value:%s", this.getValue(index)));
            this.midOrderTraversal(this.getRightIndex(index));
        }
    }

    /**
     * 后序遍历
     *
     * @param index
     */
    public void postOrderTraversal(Integer index) {
        if (null != this.getValue(index)) {
            this.postOrderTraversal(this.getLeftIndex(index));
            this.postOrderTraversal(this.getRightIndex(index));
            System.out.println(String.format("item.value:%s", this.getValue(index)));
        }
    }
}
