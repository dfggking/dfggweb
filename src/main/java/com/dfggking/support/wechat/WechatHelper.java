package com.dfggking.support.wechat;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.dfggking.cache.DictionaryHelper;

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
	
//	@Autowired
//	private HttpClientUtil httpClientHelper;
	protected String APPID; // 应用ID
	protected String SECRET; // 秘钥
	protected String Token; 
	protected String access_token; 
	
	/**
	 * 获取token接口
	 */
	public static String getTokenUrl;
	
	/**
	 * 初始化微信配置
	 */
	public void initWechatConfig(){
//		DictionaryHelper dictionaryHelper = DictionaryHelper.getInstance();
//		APPID = dictionaryHelper.getSysDictValueByCode("APPID");
//		SECRET = dictionaryHelper.getSysDictValueByCode("appsecret");
//		Token = dictionaryHelper.getSysDictValueByCode("Token");
		
		
		
		log.info("getAccessToken start.{APPID=" + APPID + ",secret:" + SECRET + "}");
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
	 * @since 1.0
	 */
	protected String getAccessToken(String corpId, String secret) {
		String accessToken = null;
		try {
//			log.info("getAccessToken start.{corpId=" + corpId + ",secret:" + secret + "}");
//			String url = MessageFormat.format(getTokenUrl, corpId, secret);
//			String httpRs = httpClientHelper.doGet(url);
//			JSONObject jsonObject = JSON.parseObject(httpRs);
//			accessToken = (String)jsonObject.get("access_token");
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
		/**
		 * 通过官方自定义生成
		 */
		return true;
	}
	
	
	
	
}









