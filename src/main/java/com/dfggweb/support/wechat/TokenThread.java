package com.dfggweb.support.wechat;

import java.util.Objects;

import com.dfggweb.util.prop.Prop;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


/**
 * 正常情况下AccessToken有效期为7200秒，即2小时。
 * 有效期内重复获取返回相同结果，并自动续期。
 * 为减少AccessToken获取的频率，通过线程定时每隔30分钟重新获取一次AccessToken
 * 定时任务
 */
public class TokenThread extends WechatHelper implements Runnable {
	private final static Logger log = LogManager.getLogger(TokenThread.class);

	public void start(){
		
		/*初始化微信配置*/
		initWechatConfig();
		getTokenUrl = Prop.getString("getTokenUrl");
		
		if(access_token == null){
			//启动定时获取AccessToken线程
			new Thread(this).start();
			log.info("============定时获取AccessToken线程启动==============");
		}
	}
	
	@Override
	public void run(){
		while(true){
			try{
				//首次启动线程时获取AccessToken
				access_token = getAccessToken(APPID, SECRET);
				try {
					if(access_token == null){
						log.info("获取AccessToken失败，请检查网络是否正常，1分钟后将再次获取！");
						Thread.sleep(1000 * 60);
					}
					/**
					 * 当首次成功获取到AccessToken后，
					 * 开始计时30分钟重新获取一次AccessToken
					 */
					if(access_token != null){
						String timer = "60"; 
						int accessTokenTimer = Objects.isNull(timer) ? 60 : Integer.parseInt(timer);
						//配置的定时时长小于1分钟或者大于119分钟则自动设置为60分钟
						if(accessTokenTimer < 1 || accessTokenTimer > 119){
							accessTokenTimer = 60;
						}
						log.info("成功获取AccessToken="+access_token + "," + accessTokenTimer + "分钟后将重新获取！");
						Thread.sleep(1000 * 60 * accessTokenTimer);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}catch(Exception ex){
				log.error("定时获取AccessToken出错",ex);
			}
		}
	}
}
