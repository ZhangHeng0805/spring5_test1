package com.zh.spring5;
/*
* 有参构造方式注入
* */
public class Orders {
    private String oname;
    private String address;

    public Orders(String oname, String address) {
        this.oname = oname;
        this.address = address;
    }
    public void print(){
        System.out.println("订单："+oname+"\t地址："+address);
    }
}
