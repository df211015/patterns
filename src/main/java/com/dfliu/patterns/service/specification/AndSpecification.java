package com.dfliu.patterns.service.specification;

import com.dfliu.patterns.domain.dto.User;

public class AndSpecification extends AbsCompositeSpecification {
    private IUserSpecification left;
    private IUserSpecification right;

    public AndSpecification(IUserSpecification left, IUserSpecification right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        return this.left.isSatisfiedBy(user) && this.right.isSatisfiedBy(user);
    }
}
