package com.hibernate;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dfggking.common.httpclient.HttpClientHelper;

@RunWith(SpringJUnit4ClassRunner.class)//基于Junit4的Spring测试框架  
@ContextConfiguration(locations={"classpath:applicationContext.xml", "classpath:dispatcherServlet.xml"})//启动Spring容器
public class TestHibernate extends AbstractJUnit4SpringContextTests {

//	@Autowired
//	public IIndexService indexService;
	
	@Autowired
	HttpClientHelper httpClientHelper;
//	@Autowired
//	WechatHelper wechatHelper;
	
	/**
	 * 优化字典工具类
	 * <p></p>
	 * <pre></pre>
	 * @author jinyf   
	 * @date 2017年3月1日 下午2:40:16 
	 * @since
	 */
	@Test
	public void testDicConfig(){
//		Prop.getS
//		DictionaryHelper.
	}
	
	
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
		String rs = httpClientHelper.doGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx5707200a7ca0596c&secret=1be8a07a3687a268fa45ba7de16febdc");
		JSONObject jsonObject = (JSONObject) JSON.parse(rs);
		System.out.println(jsonObject.get("access_token"));
		
	}
}
