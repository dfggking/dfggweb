package com.dfggweb.web.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dfggweb.entity.User;
import com.dfggweb.web.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dfggweb.common.base.BaseController;

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

    @Autowired
    private UserService userService;

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
    @ResponseBody
    public Map<String, Object> signIn(String username, String password,
                                      HttpServletRequest request, HttpServletResponse response){
//        HttpSession session = request.getSession();

        Map<String, Object> result = new HashMap<String, Object>();
        if(Objects.nonNull(username) && Objects.nonNull(password)){
            String md5HexPassword = DigestUtils.md5Hex(password);
            User userInfo = userService.getLoginUser(username, md5HexPassword);
            if(Objects.nonNull(userInfo)){
                /** 用户验证成功，执行其他业务 */



                result.put(STATUS, "OK");
                result.put(INFO, "1000");
                result.put("userInfo", userInfo);

            }else{
                result.put(STATUS, "0");
                result.put(INFO, "该用户不存在");
            }
        }else{
            result.put(STATUS, "0");
            result.put(INFO, "用户名或密码不能为空");
        }
        return result;
    }
    
    
    
    
}
