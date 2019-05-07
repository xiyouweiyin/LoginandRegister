package com.dharma.user.demo;

import com.dharma.user.demo.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    UserDao userDao;
    @Test
    public void contextLoads() {
        System.out.println(userDao.login("罗少华","123"));
    }

}
