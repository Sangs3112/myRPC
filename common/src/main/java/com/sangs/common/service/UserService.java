package com.sangs.common.service;

import com.sangs.common.model.User;

public interface UserService {
    User getUser(User user);
    default short getNumber(){
        return 1;
    }
}
