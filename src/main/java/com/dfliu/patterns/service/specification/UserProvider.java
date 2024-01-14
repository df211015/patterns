package com.dfliu.patterns.service.specification;

import com.dfliu.patterns.domain.dto.User;

import java.util.ArrayList;
import java.util.List;

public class UserProvider implements IUserProvider {
    private List<User> userList;

    public UserProvider(List<User> userList) {
        this.userList = userList;
    }

    /**
     * 过滤列表成员
     *
     * @param userSpec
     * @return
     */
    @Override
    public List<User> findUser(IUserSpecification userSpec) {
        if (null == this.userList || this.userList.isEmpty()) {
            return null;
        }
        List<User> result = new ArrayList<>();
        for (User user : this.userList) {
            if (userSpec.isSatisfiedBy(user)) {
                result.add(user);
            }
        }
        return result;
    }
}
