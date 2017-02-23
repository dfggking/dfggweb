package com.dfggking.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LoggerMain {

	private static Logger logger = LogManager.getLogger(LoggerMain.class);
	
	/**
	 * @param args
	 * @author JINYF
	 * @since 下午2:47:36
	 */
	public static void main(String[] args) {
		logger.debug("log4j debug");
		logger.info("log4j info");
		logger.warn("log4j warn");
		logger.error("log4j error");
//		logger.fatal("log4j fatal"); // 不建议
	}
}
