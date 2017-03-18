package com.dfggking.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
/**
 * 自定义全局监听器
 * <p></p>
 * <pre></pre>
 * @author jinyf   
 * @date 2017年2月24日 下午2:47:35 
 * @since 1.0
 */
public class GlobalListener implements ServletContextListener, HttpSessionListener {
	/**
	 * ServletContextListener 监听 Web应用的生命周期
	 */
	
	private final static Logger log = LogManager.getLogger(GlobalListener.class);
	
	/** 应用关闭的时候，执行本方法 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// 测试git 上传
	}
	
	/** 应用启动的时候，执行本方法 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		
	}

	/** 第一次建立Session执行 */
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/** Session超时执行 */
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
