package com.sangs.consumer;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.sangs.common.model.User;
import com.sangs.common.service.UserService;
import com.sangs.rpc.model.RpcRequest;
import com.sangs.rpc.model.RpcResponse;
import com.sangs.rpc.serializer.JDKSerializer;
import com.sangs.rpc.serializer.Serializer;

import java.io.IOException;

public class UserServiceProxy implements UserService {

    public User getUser(User user) {
        // 指定序列化器
        Serializer serializer = new JDKSerializer();
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(UserService.class.getName())
                .methodName("getUser")
                .parameterTypes(new Class[]{User.class})
                .args(new Object[]{user})
                .build();
        try{
            byte[] bodyBytes = serializer.serialize(rpcRequest);
            byte[] result;
            try (HttpResponse httpResponse = HttpRequest.post("http://localhost:8080")
                    .body(bodyBytes)
                    .execute()){
                result = httpResponse.bodyBytes();
            }
            RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
            return (User) rpcResponse.getData();
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
