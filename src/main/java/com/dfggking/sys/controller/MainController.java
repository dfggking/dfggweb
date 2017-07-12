package com.dfggking.sys.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dfggking.common.base.controller.impl.BaseController;
import com.dfggking.web.controller.IndexController;

/**
 * 
 * <p>系统管理MainController</p>
 * <pre></pre>
 * @author jinyf   
 * @date 2017年2月25日 上午11:00:41 
 * @since 1.0
 */
@Controller
public class MainController extends BaseController {

	private final static Logger log = LogManager.getLogger(MainController.class);
	
	/**
	 * 管理后台主页路径
	 * <p></p>
	 * <pre></pre>
	 * @param request
	 * @param response
	 * @throws IOException
	 * @author jinyf   
	 * @date 2017年2月25日 上午11:02:01 
	 * @since 1.0
	 */
	@RequestMapping(value = "sys/main")
	public String main(HttpServletRequest request, HttpServletResponse response) {
		return "/sys/main";
	}
}
