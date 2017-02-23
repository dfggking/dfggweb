package com.dfggking.test;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.dfggking.util.StringHelper;

public class StringHelperAPI {
	private static Logger logger = LogManager.getLogger(LoggerMain.class);
	
	private static String str = "我是一个字符串";
	
	/**
	 * @param args
	 * @author JINYF
	 * @since 下午3:48:44
	 */
	public static void main(String[] args) {
		
		
		
//		logger.info(StringHelper.isNullOrEmpty(" "));
//		logger.info(StringHelper.isNullOrNothing(null));
//		logger.info(generalSrid());
	}
	
	// 日期获取唯一编码
	private static String generalSrid(){
		return StringHelper.generalSrid();
	}
}
