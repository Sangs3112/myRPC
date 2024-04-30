package com.sangs.consumer;

import com.sangs.common.model.User;
import com.sangs.common.service.UserService;
import com.sangs.rpc.config.RpcConfig;
import com.sangs.rpc.proxy.ServiceProxyFactory;
import com.sangs.rpc.utils.ConfigUtils;


public class ConsumerExample {
    public static void main(String[] args) {
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        System.out.println(rpc);
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
