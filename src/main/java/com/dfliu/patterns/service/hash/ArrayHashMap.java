package com.dfliu.patterns.service.hash;

import com.dfliu.patterns.domain.dto.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个简单的hashMap
 */
public class ArrayHashMap {
    private Integer capacity;
    private List<Pair> buckets;


    public ArrayHashMap(Integer capacity) {
        this.buckets = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            this.buckets.add(null);
        }
    }

    /**
     * 哈希函数
     *
     * @param key
     * @return
     */
    private Integer hasFunc(Integer key) {
        Integer index = key % 100;
        return index;
    }

    public String get(Integer key) {
        Integer index = this.hasFunc(key);
        Pair pair = this.buckets.get(index);
        if (null == pair) {
            return null;
        }
        return pair.getVal();
    }

    /**
     * 添加
     *
     * @param pair
     */
    public void put(Pair pair) {
        Integer index = this.hasFunc(pair.getKey());
        this.buckets.set(index, pair);
    }

    /**
     * 删除
     *
     * @param key
     */
    public void remove(Integer key) {
        Integer index = this.hasFunc(key);
        this.buckets.set(index, null);
    }

    /**
     * 获取所有键值对
     *
     * @return
     */
    public List<Pair> pairSet() {
        List<Pair> pairSet = new ArrayList<>();
        for (Pair pair : this.buckets) {
            if (null != pair) {
                pairSet.add(pair);
            }
        }
        return pairSet;
    }

    /**
     * 获取所有键
     *
     * @return
     */
    public List<Integer> keySet() {
        List<Integer> keysSet = new ArrayList<>();
        for (Pair pair : this.buckets) {
            if (null != pair) {
                keysSet.add(pair.getKey());
            }
        }
        return keysSet;
    }

    /**
     * 获取所有值
     *
     * @return
     */
    public List<String> valueSet() {
        List<String> valuesSet = new ArrayList<>();
        for (Pair pair : this.buckets) {
            if (null != pair) {
                valuesSet.add(pair.getVal());
            }
        }
        return valuesSet;
    }
}
