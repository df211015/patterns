package com.dfliu.patterns.service.hash;

import com.dfliu.patterns.domain.dto.Pair;

public class HashMapOpenAddressing {
    /**
     * 键值对数量
     */
    private Integer size;
    /**
     * 哈希表容量
     */
    private Integer capacity;
    /**
     * 触发扩容的负载因子阈值
     */
    private final Double loadThres = 2.0 / 3.0;
    /**
     * 扩容倍数
     */
    private final Integer extendRatio = 2;
    /**
     * 桶数组
     */
    private Pair[] buckets;
    /**
     * 删除标记
     */
    private final Pair TOMBSTONE = new Pair(-1, "-1");

    public HashMapOpenAddressing() {
        this.size = 0;
        this.buckets = new Pair[this.capacity];
    }

    /**
     * 哈希函数
     *
     * @param key
     * @return
     */
    private Integer hasFunc(Integer key) {
        return key % this.capacity;
    }

    /**
     * 根据key计算对应的桶索引
     *
     * @param key
     * @return
     */
    private Integer findBucket(Integer key) {
        Integer index = this.hasFunc(key);
        Integer firstTombstone = -1;
        while (null != this.buckets[index]) {
            if (this.buckets[index].getKey().equals(key)) {
                if (!firstTombstone.equals(-1)) {
                    this.buckets[firstTombstone] = this.buckets[index];
                    this.buckets[index] = this.TOMBSTONE;
                    return firstTombstone;
                }
                return index;
            }
            // 记录遇到的首个删除标记
            if (firstTombstone.equals(-1) && buckets[index].equals(TOMBSTONE)) {
                firstTombstone = index;
            }
            // 计算桶索引，越过尾部返回头部
            index = (index + 1) % capacity;
        }
        // 若 key 不存在，则返回添加点的索引
        return firstTombstone.equals(-1) ? index : firstTombstone;
    }

    public String get(Integer key) {
        Integer index = this.findBucket(key);
        if (null != this.buckets[index] && !this.buckets[index].equals(this.TOMBSTONE)) {
            return this.buckets[index].getVal();
        }
        return null;
    }

    /* 添加操作 */
    public void put(Pair pair) {
        Integer key = pair.getKey();
        String val = pair.getVal();
        // 搜索 key 对应的桶索引
        Integer index = this.findBucket(key);
        // 若找到键值对，则覆盖 val 并返回
        if (null != this.buckets[index] && !this.buckets[index].equals(this.TOMBSTONE)) {
            this.buckets[index].setVal(val);
            return;
        }
        // 若键值对不存在，则添加该键值对
        this.buckets[index] = pair;
        this.size++;
    }

    /* 删除操作 */
    public void remove(Integer key) {
        // 搜索 key 对应的桶索引
        Integer index = this.findBucket(key);
        // 若找到键值对，则用删除标记覆盖它
        if (this.buckets[index] != null && !this.buckets[index].equals(this.TOMBSTONE)) {
            this.buckets[index] = this.TOMBSTONE;
            this.size--;
        }
    }
}
