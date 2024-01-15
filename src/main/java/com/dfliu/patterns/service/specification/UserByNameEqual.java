package com.dfliu.patterns.service.specification;

import com.dfliu.patterns.domain.dto.User;

public class UserByNameEqual extends AbsCompositeSpecification {
    private String name;

    public UserByNameEqual(String name) {
        this.name = name;
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        if (null == user) {
            return false;
        }

        return this.name.equals(user.getName());
    }
}
