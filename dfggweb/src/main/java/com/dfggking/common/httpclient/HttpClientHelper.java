package com.dfggking.common.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Map;

import com.dfggking.common.httpclient.entity.HttpResult;

/**
 * httpClientHelper
 * <p></p>
 * <pre></pre>
 * @author jinyf   
 * @date 2017年2月28日 上午11:39:39 
 * @since
 */
public interface HttpClientHelper {
	
	/**
	 * 执行GET请求
	 * <p></p>
	 * <pre></pre>
	 * @param url
	 * @return String
	 * @author jinyf   
	 * @date 2017年2月28日 上午11:41:00 
	 * @since
	 */
	String doGet(String url) throws IOException;
	
	/**
	 * 带参数的GET请求
	 * <p></p>
	 * <pre></pre>
	 * @param url
	 * @param params
	 * @return doGet
	 * @author jinyf   
	 * @throws URISyntaxException 
	 * @throws IOException 
	 * @date 2017年2月28日 上午11:43:09 
	 * @since
	 */
	String doGet(String url, Map<String, String> params) throws URISyntaxException, IOException;
	
	/**
	 * 执行POST请求
	 * <p></p>
	 * <pre></pre>
	 * @param url
	 * @return HttpResult
	 * @author jinyf   
	 * @throws UnsupportedEncodingException 
	 * @date 2017年2月28日 上午11:44:35 
	 * @since
	 */
	HttpResult doPost(String url) throws IOException;
	
	/**
	 * 执行带参数的POST请求
	 * <p></p>
	 * <pre></pre>
	 * @param url
	 * @param params
	 * @return HttpResult
	 * @author jinyf   
	 * @throws IOException 
	 * @date 2017年2月28日 上午11:44:40 
	 * @since
	 */
	HttpResult doPost(String url, Map<String, String> params) throws IOException;
	
	/**
	 * 提交json数据
	 * <p></p>
	 * <pre></pre>
	 * @param url
	 * @param json
	 * @return HttpResult
	 * @author jinyf   
	 * @date 2017年2月28日 下午3:25:23 
	 * @since
	 */
	HttpResult doPost(String url, String json);
}
