package com.dfggweb.common.base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

/**
 * <p>Controller的基类，定义了一些常量</p>
 * <pre></pre>
 * @author jinyf   
 * @date 2017年2月17日 下午2:37:40 
 * @since 1.0
 */
@Controller
public abstract class BaseController {
    private final static Logger logger = LogManager.getLogger(BaseController.class);
    
    /** 返回结果状态值， 0表示失败， 1表示成功 */
    protected final static String STATUS = "status";
    /** 返回状态说明， status为0时，info返回错误原因，否则返回OK */
    protected final static String INFO = "info";
    /** 状态码， 1000表示正确， 详情参阅info状态表 */
    protected final static String INFO_CODE = "infocode";
    /** 返回 User Cookie key值 */
    protected final String COOKIE_USERID = "COOKIE_USERID";
    
    
    
    
}
