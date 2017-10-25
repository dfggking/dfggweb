package com.dfggking.webapp.controller;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dfggking.entity.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dfggking.common.base.controller.BaseController;
import com.dfggking.sys.service.UserService;

/**
 * 移动注册Controller
 * @author dfggking@hotmail.com
 * @create 2017-07-13
 * @since 1.0
 */
@Controller
@RequestMapping(value = "/webapp/register")
public class WebAppRegisterController extends BaseController{
    private final static Logger log = LogManager.getLogger(WebAppRegisterController.class);
    /** 注册页 */
    private final static String REGISTER_INDEX = "/index";
    /** 注册提交 */
    private final static String REGISTER_SUBMIT = "submit";
    @Autowired
    private UserService userService;
    
    
    /**
     * 注册页跳转
     * @author dfggking@hotmail.com
     * @create 2017-07-13
     * @return ModelAndView
     * @since 1.0
     */
    @RequestMapping(value = REGISTER_INDEX)
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("/wechat/register");
        log.debug("RegisterController registerIndex method");
        return mv;
    }
    
    /**
     * 注册提交
     * @author dfggking@hotmail.com
     * @create 2017-07-13
     * @return ModelAndView
     * @since 1.0
     */
    @RequestMapping(value = REGISTER_SUBMIT)
    public ModelAndView register(String tel, String password, String username, HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new ModelAndView(REGISTER_SUBMIT);
        log.debug("RegisterController register method");
        
        if(Objects.isNull(tel)){
            mv.addObject(STATUS, 0);
            mv.addObject(INFO, "手机号码为空");
            return mv;
        }
        if(Objects.isNull(password)){
            mv.addObject(STATUS, 0);
            mv.addObject(INFO, "密码为空");
            return mv;
        }
        if(Objects.isNull(username)){
            mv.addObject(STATUS, 0);
            mv.addObject(INFO, "用户名为空");
            return mv;
        }
        Boolean telExist = userService.ifTelExist(tel);
        if(telExist) {
            mv.addObject(STATUS, 0);
            mv.addObject(INFO, "手机号已经注册");
            return mv;
        }
        
        User user = new User();
        userService.register(user);
        mv.addObject(STATUS, 1);
        mv.addObject(INFO, "注册成功");
        return mv;
    }
}
