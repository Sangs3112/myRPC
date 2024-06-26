package com.sangs.rpc;

import com.sangs.rpc.config.RpcConfig;
import com.sangs.rpc.constant.RpcConstant;
import com.sangs.rpc.utils.ConfigUtils;

public class RpcApplication  {
    private static volatile RpcConfig rpcConfig;

    public static void init(RpcConfig newRpcConfig){
        rpcConfig = newRpcConfig;
//        log.info("rpc init, config = {}", newRpcConfig.toString());
    }

    public static void init(){
        RpcConfig newRpcConfig;
        try{
            newRpcConfig = ConfigUtils.loadConfig(RpcConfig.class, RpcConstant.DEFAULT_CONFIG_PREFIX);
        } catch (Exception e){
            newRpcConfig = new RpcConfig();
        }
        init(newRpcConfig);
    }

    public static RpcConfig getRpcConfig(){
        if (rpcConfig == null){
            synchronized (RpcApplication.class){
                if (rpcConfig == null){
                    init();
                }
            }
        }
        return rpcConfig;
    }
}
