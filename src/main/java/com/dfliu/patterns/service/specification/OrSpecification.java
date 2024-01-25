package com.dfliu.patterns.service.specification;

import com.dfliu.patterns.domain.dto.User;

/**
 * 局部3
 */
public class OrSpecification extends AbsCompositeSpecification {
    private IUserSpecification left;
    private IUserSpecification right;

    public OrSpecification(IUserSpecification left, IUserSpecification right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfiedBy(User user) {
        return this.left.isSatisfiedBy(user) || this.right.isSatisfiedBy(user);
    }
}
