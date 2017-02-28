package com.dfggking.support.wechat;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.MessageFormat;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.UnsupportedSchemeException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 
 * <p>微信api接口工具</p>
 * <pre></pre>
 * @author jinyf   
 * @date 2017年2月20日 上午11:52:51 
 * @since
 */
public class WeixinAPIHelper {
	
	private final static Logger log = LogManager.getLogger(WeixinAPIHelper.class);
	
	public static String APPID; // 应用ID
	public static String SECRET; // 秘钥
	protected static String access_token;
	
	
	private static HttpClient webClient = null;
	/**
	 * 获取token接口
	 */
	protected static String getTokenUrl;
	/**
	 * 创建菜单
	 */
	protected static String createMenuUrl;
	/**
	 * 初始化微信配置
	 */
	public static void initWechatConfig(){
		APPID = "";
		SECRET = "";
	}
	
	/**
	 * 获取授权token
	 * <p></p>
	 * <pre></pre>
	 * @param corpId
	 * @param secret
	 * @return
	 * @author jinyf   
	 * @date 2017年2月28日 上午11:07:31 
	 * @since
	 */
	protected static String getAccessToken(String corpId, String secret) {
		String accessToken = null;
		try {
			log.info("getAccessToken start.{corpId=" + corpId + ",secret:" + secret + "}");
			String url = MessageFormat.format(getTokenUrl, corpId, secret);
			String response = executeHttpGet(url);
			accessToken = (String)JsonUtil.jsonUtil.readObjectByKey(response, "access_token");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("get access toekn exception", e);
		}
		
		return accessToken;
	}
	
	private static String executeHttpGet(String url) throws ClientProtocolException, IOException {
		ResponseHandler<?> responseHandler = new BasicResponseHandler();
		if(webClient == null){
			initWebClient();
		}
		String response = (String) webClient.execute(new HttpGet(url), responseHandler);
		return response;
	}
	
	/**
	 * 初始化创建 WebClient
	 * <p></p>
	 * <pre></pre>
	 * @author jinyf   
	 * @date 2017年2月28日 上午9:31:37 
	 * @since 1.0
	 */
	private static void initWebClient() {
		try {
			
			PoolingHttpClientConnectionManager phccMrg = new PoolingHttpClientConnectionManager();
			/** 将最大连接数设置为10 */
			phccMrg.setMaxTotal(10);
			SSLContext sslContext = SSLContext.getInstance("TLS");
//			sslContext.init(null, new X509TrustManager[]{ tm }, null);
			
			HostnameVerifier host = new HostnameVerifier() {
				
				@Override
				public boolean verify(java.lang.String hostname, SSLSession session) {
					// TODO Auto-generated method stub
					return false;
				}
			};
			HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
			SSLConnectionSocketFactory ssf = new SSLConnectionSocketFactory(sslContext, host);
			SchemePortResolver sch = new SchemePortResolver() {
				
				@Override
				public int resolve(HttpHost host) throws UnsupportedSchemeException {
					return 0;
				}
			};
			
			SchemePortResolver sch = new SchemePortResolver("https", 443, ssf);
			tcm.getSchemeRegistry().register(sch);
			webClient = null;
		} catch (Exception ex) {
			log.error("initWebClient exception", ex);
		} finally {
			log.info("initWebClient end....");
		}
	}

}









