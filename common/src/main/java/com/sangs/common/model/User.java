package com.sangs.common.model;

import java.io.Serializable;

public class User implements Serializable {
    // 对象需要实现序列化接口,为了后续可以进行网络传输
    private String name;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
