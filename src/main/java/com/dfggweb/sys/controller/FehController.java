package com.dfggweb.sys.controller;

import com.dfggweb.common.base.BaseController;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Feh Controller
 * @author dfggking@hotmail.com
 * @vertion 1.0
 */
@Controller
public class FehController extends BaseController {
    private final static Logger LOGGER = LogManager.getLogger(FehController.class);

    private final static String APP_URL = "/feh/app";

    @RequestMapping(value = APP_URL)
    public ModelAndView toAppPage(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new ModelAndView(APP_URL);
        LOGGER.debug("TO FEH APP");
        return mv;
    }

}
