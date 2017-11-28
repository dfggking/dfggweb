package com.service;

import com.dfggweb.web.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestUserService extends AbstractJUnit4SpringContextTests {
    
    @Autowired
    UserServiceImpl userService;


    @Test
    public void testRegister(){
        userService.getLoginUser("dfggking", "123456");
    }



}
