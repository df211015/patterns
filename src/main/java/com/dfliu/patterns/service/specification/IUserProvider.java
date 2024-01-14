package com.dfliu.patterns.service.specification;

import com.dfliu.patterns.domain.dto.User;

import java.util.List;

public interface IUserProvider {
    List<User> findUser(IUserSpecification userSpec);
}