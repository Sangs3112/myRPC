package com.sangs.rpc.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MockServiceProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 根据方法的返回值类型,生成特定的默认值对象
        Class<?> methodReturnType = method.getReturnType();
        return getDefaultObject(methodReturnType);
    }

    private Object getDefaultObject(Class<?> type){
        if (type.isPrimitive()){
            if (type == boolean.class){
                return false;
            }else if (type == short.class){
                return (short) 0;
            }else if (type == int.class){
                return 0;
            }else if (type == long.class){
                return 0L;
            }
        }
        return null;
    }
}
