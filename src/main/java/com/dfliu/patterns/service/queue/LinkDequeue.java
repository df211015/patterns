package com.dfliu.patterns.service.queue;

import com.dfliu.patterns.domain.dto.ListNodePlus;

public class LinkDequeue {
    private ListNodePlus<Integer> front;
    private ListNodePlus<Integer> rear;
    private Integer queSize;

    public Integer size() {
        return this.queSize;
    }

    /**
     * 判断队列是否空
     *
     * @return
     */
    public Boolean isEmpty() {
        return this.size().equals(0);
    }

    /**
     * 入队列
     *
     * @param v       队列项值
     * @param isFront 是否从头部入队列
     */
    public void push(Integer v, Boolean isFront) {
        ListNodePlus<Integer> node = this.buildNode(v);
        Boolean empty = this.isEmpty();
        if (empty) {
            this.front = node;
            this.rear = node;
        }
        if (isFront) {
            this.front.setPre(node);
            node.setNext(this.front);
            this.front = node;
        } else {
            this.rear.setNext(node);
            node.setPre(this.rear);
            this.rear = node;
        }
        this.queSize++;
    }

    /**
     * 出队列
     *
     * @param isFront 是否从头部出队列
     * @return
     */
    public Integer pop(Boolean isFront) {
        Boolean empty = this.isEmpty();
        if (empty) {
            System.out.println("队列空,不支持出队列");
            return null;
        }
        Integer data = null;
        if (isFront) {
            data = this.front.getData();
            this.front.getNext().setPre(null);
            this.front.setNext(null);
            this.front = this.front.getNext();
        } else {
            data = this.rear.getData();
            this.rear.getPre().setNext(null);
            this.rear.setPre(null);
            this.rear = this.rear.getPre();
        }
        this.queSize--;

        return data;
    }

    private ListNodePlus<Integer> buildNode(Integer v) {
        ListNodePlus<Integer> node = new ListNodePlus<>();
        node.setData(v);
        node.setNext(null);
        node.setPre(null);
        return node;
    }
}
