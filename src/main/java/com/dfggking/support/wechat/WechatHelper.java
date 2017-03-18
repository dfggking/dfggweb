package com.dfggking.support.wechat;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dfggking.common.httpclient.HttpClientHelper;

/**
 * 微信接口工具
 * <p></p>
 * <pre></pre>
 * @author jinyf
 * @date 2017年2月20日 上午11:52:51
 * @since 1.0
 */
@Component
public class WechatHelper {
	
	private final static Logger log = LogManager.getLogger(WechatHelper.class);
	
	@Autowired
	private HttpClientHelper httpClientHelper;
	public static String APPID; // 应用ID
	public static String SECRET; // 秘钥
	protected static String access_token;
	
	/**
	 * 获取token接口
	 */
	public static String getTokenUrl;
	/**
	 * 创建菜单
	 */
	public static String createMenu;
	/**
	 * 初始化微信配置
	 */
	public static void init(){
		
		
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
	protected String getAccessToken(String corpId, String secret) {
		String accessToken = null;
		try {
			log.info("getAccessToken start.{corpId=" + corpId + ",secret:" + secret + "}");
			String url = MessageFormat.format(getTokenUrl, corpId, secret);
			String httpRs = httpClientHelper.doGet(url);
			JSONObject jsonObject = JSON.parseObject(httpRs);
			accessToken = (String)jsonObject.get("access_token");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("get access toekn exception", e);
		}
		
		return accessToken;
	}

	/**
	 * 创建公众号自定义菜单
	 * <p></p>
	 * <pre></pre>
	 * @return
	 * @author jinyf   
	 * @date 2017年3月1日 下午1:55:35 
	 * @since
	 */
	protected boolean createMenu() {
		Map<String, String> mapData = new HashMap<String, String>();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> mapChild = new HashMap<String, Object>();
		mapChild.put("type", "click");
		mapChild.put("name", "今日头条");
		mapChild.put("key", "http://www.baidu.com");
		list.add(mapChild);
		mapData.put("button", list.toString());
		String url = MessageFormat.format(createMenu, access_token);
		try {
			String rs = httpClientHelper.doGet(url, mapData);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
}









