package com.dfggking.web.common.base;

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
	private final static Logger log = LogManager.getLogger(BaseController.class);
	
	/** 返回数据的key值 */
	final static String ROOT = "ROOT";

	/** 返回处理结果的key值 */
	protected final static String RESULT = "RESULT";

	/** 表示成功的处理结果 */
	protected final static String SUCCESS = "SUCCESS";

	/** 返回提示消息的key值 */
	protected final static String INFO = "INFO";

	/** 返回警告消息的key值 */
	protected final static String WARN = "WARN";
	
	/** 表示失败的处理结果 */
	protected final static String FAILED = "FAILED";

	/** 返回 User Cookie key值 */
	protected final String COOKIE_USERID = "COOKIE_USERID";
}
