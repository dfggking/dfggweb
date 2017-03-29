package com.dfggking.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 移动端Main页面
 * <p></p>
 * <pre></pre>
 * @author jinyf   
 * @date 2017年3月20日 下午2:22:38 
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/wechat")
public class WechatMainController {
	
	private final static Logger log = LogManager.getLogger(WechatMainController.class);
	
	@RequestMapping(value = "index")
	public String frontMain(HttpServletRequest request, HttpServletResponse response){
		
		log.debug("wechat/index");
		
		
		return "/wechat/index";
	}
}
