package com.dfliu.patterns.service.queue;

/**
 * 基于数组实现的环形队列
 */
public class ArrayQueue {
    //用于存储队列元素的数组
    private Integer[] nums;
    //队首指针，指向队首元素
    private Integer front;
    //队列长度
    private Integer queSize;

    public void init(Integer size) {
        this.nums = new Integer[size];
        this.front = 0;
        this.queSize = 0;
    }

    public Integer getCapacity() {
        return this.nums.length;
    }

    public void push(Integer v) {
        if (this.queSize.equals(this.getCapacity())) {
            System.out.println("队列已满!");
            return;
        }
        Integer rear = (this.front + this.queSize) % this.getCapacity();
        this.nums[rear] = v;
        this.queSize++;
    }

    public Boolean isEmpty() {
        if (this.queSize.equals(0)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    public Integer peek() {
        Boolean flag = this.isEmpty();
        if (!flag) {
            return this.nums[this.front];
        }
        return null;
    }

    public Integer pop() {
        Integer num = this.peek();
        this.front = (this.front + 1) % this.getCapacity();
        this.queSize--;

        return num;
    }
}