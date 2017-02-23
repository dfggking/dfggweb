package com.dfggking.web.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dfggking.web.common.base.BaseController;

@Controller
public class IndexController extends BaseController {
	private final static Logger log = LogManager.getLogger(IndexController.class);
	
	/**
	 * 
	 * <p>微信公众号接口握手验证</p>
	 * <pre></pre>
	 * @param signature 加密签名
	 * @param timestamp 时间戳
	 * @param nonce 随机数
	 * @param echostr 随机字符串
	 * @author jinyf   
	 * @throws IOException 
	 * @date 2017年2月20日 上午9:31:13 
	 * @since 1.0
	 */
	@RequestMapping(value = "wechat/hello")
	public void hello(HttpServletRequest request, HttpServletResponse response, String signature, String timestamp, String nonce, String echostr) throws IOException {
		log.info("signature: " + signature);
		log.info("timestamp: " + timestamp);
		log.info("nonce: " + nonce);
		log.info("echostr: " + echostr);
		log.info("return new");
		OutputStream os = response.getOutputStream();
		os.write(echostr.getBytes("UTF-8"));
		os.flush();
		os.close();
	}
	
}
