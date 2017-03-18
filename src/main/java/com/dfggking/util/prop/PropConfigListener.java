package com.dfggking.util.prop;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.dfggking.util.StringHelper;


public class PropConfigListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		;
	}

	public void contextInitialized(ServletContextEvent arg0) {
		String propConfigLocation = arg0.getServletContext().getInitParameter("propConfigLocation");
		arg0.getServletContext().log("Initializing Prop from [" + propConfigLocation + "]");
		if (!StringHelper.isNullOrEmpty(propConfigLocation)) {
			if (propConfigLocation.startsWith("classpath:")) {
				Prop.load(propConfigLocation.substring(10));
			}
		}
	}

}
