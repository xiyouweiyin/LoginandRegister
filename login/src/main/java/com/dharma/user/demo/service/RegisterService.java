package com.dharma.user.demo.service;

import com.dharma.user.demo.dao.RegisterDao;
import com.dharma.user.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService {
    @Autowired
    private RegisterDao registerDao;

    public void save(@NonNull User user){
        registerDao.save(user);
    }
    public List<User> findByName(String username){
        return registerDao.findByName(username);
    }
}
