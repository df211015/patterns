package com.dfliu.patterns.service.queue;

import com.dfliu.patterns.domain.dto.ListNode;

public class LinkQueue {
    private ListNode<Integer> front;
    /**
     * 追加尾结点,优化了插入结点的算法,不用每次追加结点时进行遍历
     */
    private ListNode<Integer> rear;

    public void push(Integer v) {
        ListNode<Integer> newNode = this.buildNode(v);
        if (null == this.front) {
            this.front = newNode;
            this.rear = newNode;
            return;
        }
        //将新结点挂在当前尾结点后面
        this.rear.setNext(newNode);
        //将尾结点指向新结点
        this.rear = newNode;
    }

    public Integer pop() {
        if (null == this.front) {
            return null;
        }
        Integer data = this.front.getData();
        this.front = this.front.getNext();
        return data;
    }

    private ListNode<Integer> buildNode(Integer v) {
        ListNode<Integer> node = new ListNode<>();
        node.setData(v);
        node.setNext(null);
        return node;
    }
}