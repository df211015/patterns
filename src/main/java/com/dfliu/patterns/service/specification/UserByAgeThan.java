package com.dfliu.patterns.service.specification;

import com.dfliu.patterns.domain.dto.User;

public class UserByAgeThan extends AbsCompositeSpecification {
    private Integer age;

    public UserByAgeThan(Integer age) {
        this.age = age;
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        if (null == user) {
            return false;
        }

        return this.age > user.getAge();
    }
}
