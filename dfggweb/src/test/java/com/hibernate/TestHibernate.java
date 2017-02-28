package com.hibernate;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dfggking.common.httpclient.HttpClientHelper;
import com.dfggking.common.httpclient.entity.HttpResult;

@RunWith(SpringJUnit4ClassRunner.class)//基于Junit4的Spring测试框架  
@ContextConfiguration(locations={"classpath:applicationContext.xml", "classpath:dispatcherServlet.xml"})//启动Spring容器
public class TestHibernate extends AbstractJUnit4SpringContextTests {

//	@Autowired
//	public IIndexService indexService;
	
	@Autowired
	HttpClientHelper httpclient;
	
	/**
	 * 测试http请求POST
	 * <p></p>
	 * <pre></pre>
	 * @throws IOException
	 * @author jinyf   
	 * @date 2017年2月28日 下午5:45:20 
	 * @since
	 */
	@Test
	public void testHttpClient() throws IOException {
		HttpResult httpResult = httpclient.doPost("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=SECRET");
		System.out.println(httpResult.getData());
	}
}
