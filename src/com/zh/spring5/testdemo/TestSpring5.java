package com.zh.spring5.testdemo;

import com.zh.spring5.Book;
import com.zh.spring5.Orders;
import com.zh.spring5.User;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestSpring5 {
    /*@Test
    public void testAdd(){
        //加载spring配置文件
        *//*
        * IOC容器实现的两种方式（两个接口）：
        * （1）BeanFactory：是Spring内部接口，不提供开发人员使用
        *（加载配置文件时不会创建对象，获取对象（使用）才去创建对象）
        * （2）ApplicationContext：BeanFactory的子接口，提供更多更强大的功能，一般面向开发人员
        *（加载配置文件时就会把配置文件里面的对象创建）
        * *//*
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        User user=context.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }*/

    @Test
    public void testBook1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        Book book=context.getBean("book",Book.class);
        System.out.println(book);
        book.print();
    }

    /*@Test
    public void testOrders(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        Orders orders=context.getBean("orders", Orders.class);
        System.out.println(orders);
        orders.print();
    }*/
}
