package com.dfliu.patterns.service.specification;

import com.dfliu.patterns.domain.dto.User;

public interface IUserSpecification {
    boolean isSatisfiedBy(User user);

    IUserSpecification and(IUserSpecification spec);

    IUserSpecification or(IUserSpecification spec);

    IUserSpecification not();
}
