package com.dfliu.patterns.service.specification;

import com.dfliu.patterns.domain.dto.User;

/**
 * 局部2
 */
public class NotSpecification extends AbsCompositeSpecification {
    private IUserSpecification spec;

    public NotSpecification(IUserSpecification spec) {
        this.spec = spec;
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        return !this.spec.isSatisfiedBy(user);
    }
}
