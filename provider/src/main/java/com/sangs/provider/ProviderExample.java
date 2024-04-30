package com.sangs.provider;

import com.sangs.common.service.UserService;
import com.sangs.rpc.RpcApplication;
import com.sangs.rpc.registry.LocalRegistry;
import com.sangs.rpc.server.HttpServer;
import com.sangs.rpc.server.VertxHttpServer;

public class ProviderExample {
    public static void main(String[] args){
        RpcApplication.init();

        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStrat(8080);
    }
}
