package com.hibernate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dfggking.web.service.IIndexService;

@RunWith(SpringJUnit4ClassRunner.class)//基于Junit4的Spring测试框架  
@ContextConfiguration(locations={"classpath:applicationContext.xml", "classpath:dispatcherServlet.xml"})//启动Spring容器
public class TestHibernate extends AbstractJUnit4SpringContextTests {

	@Autowired
	public IIndexService indexService;
	
	@Test
	public void testHello() {
		
	}
}
