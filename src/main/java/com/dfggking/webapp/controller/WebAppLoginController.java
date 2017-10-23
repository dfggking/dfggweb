package com.dfggking.webapp.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dfggking.common.base.controller.BaseController;

/**
 * 微信APP登录Controller
 * @author dfggking@hotmail.com
 * @date 2017-06-29
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/webapp/login")
public class WebAppLoginController extends BaseController {
    private final static Logger log = LogManager.getLogger(WebAppLoginController.class);
    /** 移动登录页 */
    private final static String LOGIN_INDEX = "/index";
    /** 登录请求 */
    private final static String SIGN_IN = "/signIn";
    
    /**
     * 登录页跳转
     * @author dfggking@hotmail.com
     * @date 2017-07-04
     * @return ModelAndView
     * @version 1.0
     */
    @RequestMapping(value = LOGIN_INDEX)
    public ModelAndView loginPage(){
        ModelAndView mv = new ModelAndView("/wechat/login");
        log.debug("LoginController loginPage method");
        return mv;
    }
    
    /**
     * 登录请求
     * <p>如何写出一个完美的登录请求</p>
     * @author dfggking@hotmail.com
     * @date 2017-07-04
     * @return ModelAndView
     * @version 1.0
     */
    @RequestMapping(value = SIGN_IN)
    public ModelAndView signIn(){
        ModelAndView mv = new ModelAndView(SIGN_IN);
        log.debug("LoginController signIn method");
        
        
        
        return mv;
    }
}
