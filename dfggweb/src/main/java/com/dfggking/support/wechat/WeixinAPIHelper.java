package com.dfggking.support.wechat;

/**
 * 
 * <p>微信api接口工具</p>
 * <pre></pre>
 * @author jinyf   
 * @date 2017年2月20日 上午11:52:51 
 * @since
 */
public class WeixinAPIHelper {
	
	public static String CorpId;
	public static String agentId;
	protected static String Secret;
	protected static String access_token;
	/**
	 * 获取token接口
	 */
	protected static String getTokenUrl;
	/**
	 * 获取微信用户信息接口
	 */
	protected static String getUserInfoUrl;
	protected static String getUserInfoByCodeUrl;
	/**
	 * 创建菜单
	 */
	protected static String createMenuUrl;
	/**
	 * 初始化微信配置
	 */
	/*public static void initWechatConfig(){
		DictionaryUtil dictUtil = DictionaryUtil.getInstance();
		//从资源文件中初始化微信配置信息
		CorpId = dictUtil.getSysDictValueByCode("CorpId");
		Secret = dictUtil.getSysDictValueByCode("Secret");
		agentId = dictUtil.getSysDictValueByCode("agentId");
		
		*//** ---------微信回调模式密钥配置-----------begin*//*
		Token = dictUtil.getSysDictValueByCode("Token");
		EncodingAESKey = dictUtil.getSysDictValueByCode("EncodingAESKey");
		EVENT_WECHART_OPEN_KEY = dictUtil.getSysDictValueByCode("EVENT_WECHART_OPEN_KEY");	//开启微信通知事件Key
		EVENT_WECHART_CLOSE_KEY = dictUtil.getSysDictValueByCode("EVENT_WECHART_CLOSE_KEY");	//关闭微信通知事件Key
		*//** ---------微信回调模式密钥配置-----------end*//*
		
		//客户根目录
		rootDepartmentId = dictUtil.getSysDictValueByCode("rootDepartmentId");
		//运维根目录
		rootDepartmentId_YW = dictUtil.getSysDictValueByCode("rootDepartmentId_YW");
	}
	
	
	*//**
	 * @desc 获取授权token
	 * @param corpId
	 * @param secret
	 * @return
	 *//*
	protected static String getAccessToken(String corpId, String secret) {
		String accessToken = null;
		try {
//			log.info("getAccessToken start.{corpId=" + corpId + ",secret:"
//					+ secret + "}");
			String url = MessageFormat.format(getTokenUrl, corpId, secret);
			String response = executeHttpGet(url);
			accessToken = (String)JsonUtil.jsonUtil.readObjectByKey(response, "access_token");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("get access toekn exception", e);
		}
		
		 * 推送access_token到演练系统和会议系统，先暂时用指挥中心新企业号 2016-10-25 孙建波
		 
		try{
			List<XfzDictionaryVo> list=DictionaryUtil.getInstance().getSysDictListByCode("synchroAccessToken");
			if(list!=null){
				for(XfzDictionaryVo vo:list){
					setTokenUrl=vo.getDicValue();
					Map<String,String> param=new HashMap<String,String>();
					param.put("token", accessToken);
					HttpHelper.postHttpClient(setTokenUrl, param);
				}
			}
			
		}catch(Exception ex){
			
		}
		return accessToken;
	}*/
	
	
}
