package com.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.dfggking.entity.User;
import com.dfggking.sys.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestUserService extends AbstractJUnit4SpringContextTests {
    
    @Autowired
    UserServiceImpl userService;
    
    
    @Test
    public void testRegister(){
        User user = new User();
        user.setPassword("123456");
//        userService.register(user);
    }
    
    @Test
    public void testGetUserById() {
        userService.getUserById("1");
    }
    
    
}
