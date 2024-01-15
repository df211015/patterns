package com.dfliu.patterns.service.specification;

import com.dfliu.patterns.domain.dto.User;

public abstract class AbsCompositeSpecification implements IUserSpecification {

    public abstract boolean isSatisfiedBy(User user);

    @Override
    public IUserSpecification and(IUserSpecification spec) {
        return new AndSpecification(this, spec);
    }

    @Override
    public IUserSpecification or(IUserSpecification spec) {
        return new OrSpecification(this, spec);
    }

    @Override
    public IUserSpecification not() {
        return new NotSpecification(this);
    }
}