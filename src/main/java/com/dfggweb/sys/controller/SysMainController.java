package com.dfggweb.sys.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dfggweb.common.base.BaseController;

/**
 * 
 * 系统管理
 * @author dfggking@hotmail.com
 * @date 2017年2月25日 上午11:00:41
 * @since 1.0
 */
@Controller
@RequestMapping(value="/sys")
public class SysMainController extends BaseController {
    private final static Logger logger = LogManager.getLogger(SysMainController.class);
    
    private final static String SYS_MAIN_URL = "main";
    private final static String SYS_TESTJSON = "testjson";
    
    /**
     * 管理后台主页路径
     * @throws IOException
     * @author jinyf
     * @date 2017年2月25日 上午11:02:01
     * @since 1.0
     */
    @RequestMapping(value = SYS_MAIN_URL)
    public String sysMain(HttpServletRequest request, HttpServletResponse response){
        logger.debug("SYS_MAIN_PAGE");

        return "/sys/main";
    }


}
