package com.dfliu.patterns.service.pool;

import com.dfliu.patterns.domain.dto.User;

public class ConcreteCacheObj extends ObjectPool<User> {

    @Override
    public User createObj() {
        return new User("最爱咖啡", 40);
    }
}
