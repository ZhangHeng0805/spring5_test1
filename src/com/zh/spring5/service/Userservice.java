package com.zh.spring5.service;

import com.zh.spring5.dao.UserDao;
import com.zh.spring5.dao.UserDaoImpl;

public class Userservice {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("service add.......");
        userDao.update();
    }


}
