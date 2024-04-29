package com.sangs.provider;

import com.sangs.common.model.User;
import com.sangs.common.service.UserService;

public class UserServiceImpl implements UserService {

    public User getUser(User user) {
        System.out.println("用户名: " + user.getName());
        return user;
    }
}
