package com.springtransaction;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author dfggking@hotmail.com
 * @create 2017-09-23
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class) // 基于JUnit4的Spring测试框架
@ContextConfiguration(locations={"classpath:applicationcontexttest.xml"})
public class SpringTransactionTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    /**
     * @author dfggking@hotmail.com
     * @create 2017-09-23
     * @return void
     * @since 1.0
     */
    @Test
    public void connectTest() {
        String sql = "select * from user";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list.size());
    }
    
    @Test
    public void addUser() {
        
        
    }
    
}
