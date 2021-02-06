package com.zh.spring5.testdemo;


import com.zh.spring5.bean.Emp;
import com.zh.spring5.service.Userservice;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {
    /*@Test
    public void testBean1(){
        //加载spring配置文件
        *//*
        * IOC容器实现的两种方式（两个接口）：
        * （1）BeanFactory：是Spring内部接口，不提供开发人员使用
        *（加载配置文件时不会创建对象，获取对象（使用）才去创建对象）
        * （2）ApplicationContext：BeanFactory的子接口，提供更多更强大的功能，一般面向开发人员
        *（加载配置文件时就会把配置文件里面的对象创建）
        * *//*
        ApplicationContext context=new ClassPathXmlApplicationContext("bean2.xml");
        Userservice userservice=context.getBean("userService", Userservice.class);
//        System.out.println(userservice);
        userservice.add();
    }*/
    @Test
    public void testBean2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean4.xml");
        Emp emp=context.getBean("emp",Emp.class);
        emp.add();
    }


}
