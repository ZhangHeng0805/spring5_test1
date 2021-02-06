package com.zh.spring5;
/*
* set方式注入
* */
public class Book {
    private String bname;
    private String bauthor;
    private String address;
    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void print(){
        System.out.println("书名："+bname+"\t作者："+bauthor+"\t地址："+address);
    }

}
