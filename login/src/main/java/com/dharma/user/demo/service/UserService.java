package com.dharma.user.demo.service;

import com.dharma.user.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public String login(String name,String password){
        return userDao.login(name,password);
    }
}
