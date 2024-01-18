package com.dfliu.patterns.service.pool;

import com.dfliu.patterns.domain.constants.EPoolObjStatus;

import java.util.Hashtable;

public abstract class ObjectPool<T> {
    private Hashtable<T, ObjectStatus> pool = new Hashtable<>();

    /**
     * 初始化时创建对像,并放入到池中
     */
    public ObjectPool() {
        this.pool.put(this.createObj(), new ObjectStatus());
    }

    /**
     * 从池中取出空闲元素
     *
     * @return
     */
    public synchronized T checkOut() {
        for (T t : this.pool.keySet()) {
            if (this.pool.get(t).validate()) {
                this.pool.get(t).setUsing();
                return t;
            }
        }
        return null;
    }

    /**
     * 归还对象
     *
     * @param t
     */
    public synchronized void checkIn(T t) {
        this.pool.get(t).setFree();
    }

    class ObjectStatus {
        private Integer status = EPoolObjStatus.free.getCode();

        /**
         * 占用
         */
        public void setUsing() {
            this.status = EPoolObjStatus.using.getCode();
        }

        /**
         * 释放
         */
        public void setFree() {
            this.status = EPoolObjStatus.free.getCode();
        }

        /**
         * 检查是否可用
         *
         * @return
         */
        public boolean validate() {
            if (EPoolObjStatus.free.getCode().equals(this.status)) {
                return true;
            }
            return false;
        }
    }

    /**
     * 创建缓存对像
     *
     * @return
     */
    public abstract T createObj();
}
