package com.dfliu.patterns.service.queue;

/**
 * 相比较数组方式的双向队列,就是在原来单向队列的基础上追加了队首入队和队尾出队的方法
 */
public class ArrayDequeue {
    //用于存储双向队列元素的数组
    private Integer[] nums;
    //队首指针
    private Integer front;
    //双向队列长度
    private Integer queSize;

    public ArrayDequeue(Integer num) {
        this.nums = new Integer[num];
        this.front = 0;
        this.queSize = 0;
    }

    /**
     * 获取队列容量
     *
     * @return
     */
    public Integer getCapacity() {
        return this.nums.length;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public Boolean isEmpty() {
        return this.queSize.equals(0);
    }

    public Boolean isFull() {
        return this.queSize.equals(this.nums.length);
    }

    /**
     * 获取环形队列的索引值
     *
     * @param i
     * @return
     */
    public Integer getIndex(Integer i) {
        return (i + this.getCapacity()) % this.getCapacity();
    }

    /**
     * 队首入队
     *
     * @param v
     */
    public void pushFirst(Integer v) {
        if (this.isFull()) {
            System.out.println("队列已满,入队失败!");
            return;
        }
        Integer index = this.getIndex(this.front - 1);
        this.nums[index] = v;
        this.queSize++;
    }

    /**
     * 队尾出队
     *
     * @return
     */
    public Integer popLast() {
        if (this.isEmpty()) {
            System.out.println("队列空,出队失败!");
            return null;
        }
        Integer index = this.getIndex(this.front + this.queSize - 1);
        Integer num = this.nums[index];
        this.queSize--;

        return num;
    }
}