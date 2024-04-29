package com.sangs.consumer;

import com.sangs.common.model.User;
import com.sangs.common.service.UserService;
import com.sangs.rpc.proxy.ServiceProxyFactory;


public class ConsumerExample {
    public static void main(String[] args) {
        // 静态代理
//        UserService userService = new UserServiceProxy();
        // 动态代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("sangs");
        User newUser = userService.getUser(user);
        if (newUser != null){
            System.out.println(newUser.getName());
        }else{
            System.out.println("user == null");
        }
    }
}
