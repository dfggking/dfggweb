package com.dfggking.web.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dfggking.common.base.controller.BaseController;

/**
 * PC端登录Controller
 * @author dfggking@hotmail.com
 * @date 2017-06-28
 * @version 1.0
 */
@Controller
@RequestMapping(value="/web/login")
public class LoginController extends BaseController {
    
    private final static Logger log = LogManager.getLogger(LoginController.class);
    /** 登录页跳转 */
    private final static String LOGIN = "/";
    /** 登录请求 */
    private final static String SIGN_IN = "/signIn";
    /** 用户注册 */
    private final static String REGISTER = "/register";
    /** 注销 */
    private final static String LOGINOUT = "/signOut";
    /** 临时访问 */
    private final static String MAIN = "/main";
    
    /**
     * 登录页跳转
     * @author dfggking@hotmail.com
     * @date 2017-06-29
     * @version 1.0
     */
    @RequestMapping(value = LOGIN)
    public ModelAndView loginIndex(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new ModelAndView("/front/login");
        return mv;
    }
    
    /**
     * 意志主页跳转
     * @author dfggking@hotmail.com
     * @create 2017-10-20
     * @return ModelAndView
     * @since 1.0
     */
    @RequestMapping(value = MAIN)
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new ModelAndView("/front/main");
        return mv;
    }
    
    /**
     * 登录
     * @author dfggking@hotmail.com
     * @date 2017-06-29
     * @version 1.0
     */
    @RequestMapping(value = SIGN_IN)
    public ModelAndView signIn(String username, String password, HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new ModelAndView(SIGN_IN);
        
        HttpSession session = request.getSession();
        
        if(Objects.isNull(username) && Objects.isNull(password)){
            
        }
        return mv;
    }
    
    
    
    
}
