package com.dfliu.patterns.service.hash;

import com.dfliu.patterns.domain.dto.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用链式地址处理哈希冲突
 */
public class HashMapChaining {
    /**
     * 键值对数量
     */
    private Integer size;
    /**
     * 哈希表容量
     */
    private Integer capacity;
    /**
     * 桶数量
     */
    private List<List<Pair>> buckets;

    public HashMapChaining() {
        this.size = 0;
        this.capacity = 4;
        this.buckets = new ArrayList<>(this.capacity);
        for (int i = 0; i < this.capacity; i++) {
            this.buckets.add(new ArrayList<>());
        }
    }

    /**
     * 哈希函数
     *
     * @param key
     * @return
     */
    public Integer hasFunc(Integer key) {
        return key % this.capacity;
    }

    /**
     * 负载因子
     *
     * @return
     */
    public Double loadFactor() {
        double factor = Double.parseDouble(String.valueOf(this.size / this.capacity));
        return factor;
    }

    /**
     * 根据key查询
     *
     * @param key
     * @return
     */
    public String get(Integer key) {
        Integer index = this.hasFunc(key);
        List<Pair> bucket = this.buckets.get(index);
        for (Pair pair : bucket) {
            if (pair.getKey().equals(key)) {
                return pair.getVal();
            }
        }
        return null;
    }

    /**
     * 添加元素,未考虑扩容
     *
     * @param pair
     */
    public void put(Pair pair) {
        Integer key = pair.getKey();
        String val = pair.getVal();
        Integer index = this.hasFunc(key);
        List<Pair> bucket = this.buckets.get(index);
        for (Pair item : bucket) {
            if (item.getKey().equals(key)) {
                item.setVal(val);
                return;
            }
        }
        bucket.add(pair);
        this.size++;
    }

    /**
     * 删除元素
     *
     * @param key
     */
    public void remove(Integer key) {
        Integer index = this.hasFunc(key);
        List<Pair> bucket = this.buckets.get(index);
        for (Pair item : bucket) {
            if (item.getKey().equals(key)) {
                bucket.remove(item);
                this.size--;
            }
        }
    }
}
