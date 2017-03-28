package com.dfggking.common.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dfggking.common.httpclient.entity.HttpResult;

/**
 * httpClientHelper
 * <p></p>
 * <pre></pre>
 * @author jinyf   
 * @date 2017年2月28日 上午11:39:39 
 * @since
 */
@Component
public class HttpClientHelper {
	private final static Logger log = LogManager.getLogger(HttpClientHelper.class);
	
	@Autowired
	private CloseableHttpClient httpClient;
	@Autowired
	private RequestConfig requestConfig;
	
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
	public String doGet(String url) throws IOException {
		HttpGet httpGet = new HttpGet(url);
		httpGet.setConfig(requestConfig);
		CloseableHttpResponse response = null;
		
		/**执行请求*/
		try {
			response = httpClient.execute(httpGet);
			/*判断返回状态是否为200*/
			if(Objects.equals(response.getStatusLine().getStatusCode(), 200)){
				return EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(Objects.isNull(response)){
				response.close();
			}
		}
		return "";
	}
	
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
	public String doGet(String url, Map<String, String> params) throws URISyntaxException, IOException {
		URIBuilder uriBuilder = new URIBuilder(url);
		for(String key : params.keySet()){
			uriBuilder.addParameter(key, params.get(key));
		}
		return this.doGet(uriBuilder.build().toString());
	}
	
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
	public HttpResult doPost(String url) throws IOException {
		return this.doPost(url, "");
	}
	
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
	public HttpResult doPost(String url, Map<String, String> params) throws IOException {
		/*创建http POST请求*/
		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(requestConfig);
		if(Objects.isNull(params)){
			/*设置2个post参数,一个scope,一个q*/
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
			for(String key : params.keySet()){
				parameters.add(new BasicNameValuePair(key, params.get(key)));
			}
			/**构造一个form表单式的实体*/
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters, "UTF-8");
			httpPost.setEntity(formEntity);
		}
		CloseableHttpResponse response = null;
		try {
			/**执行请求*/
			response = httpClient.execute(httpPost);
			return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity(), "UTF-8"));
		} catch (ClientProtocolException e) {
			log.error(e);
			e.printStackTrace();
		} catch (IOException e) {
			log.error(e);
			e.printStackTrace();
		} finally {
			if(Objects.isNull(response)){
				response.close();
			}
		}
		return new HttpResult();
	}
	
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
	public HttpResult doPost(String url, String json) {
		/**创建http POST请求*/
		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(requestConfig);
		if(Objects.isNull(json)){
			/**构造一个form表单式的实体*/
			StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
			/**将请求实体设置到httpPost对象中*/
			httpPost.setEntity(stringEntity);
		}
		CloseableHttpResponse response = null;
		/**执行请求*/
		try {
			response = this.httpClient.execute(httpPost);
			return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity(), "UTF-8"));
		} catch (ClientProtocolException e) {
			log.error(e);
			e.printStackTrace();
		} catch (IOException e) {
			log.error(e);
			e.printStackTrace();
		}
		return new HttpResult();
	}
}
