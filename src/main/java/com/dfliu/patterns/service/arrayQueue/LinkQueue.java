package com.dfliu.patterns.service.arrayQueue;

import com.dfliu.patterns.domain.dto.ListNode;

public class LinkQueue {
    private ListNode<Integer> front;

    public void push(Integer v) {
        ListNode<Integer> newNode = this.buildNode(v);
        if (null == this.front) {
            this.front = newNode;
            return;
        }
        ListNode<Integer> iterator = this.front;
        while (null != iterator.getNext()) {
            iterator = iterator.getNext();
        }
        iterator.setNext(newNode);
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