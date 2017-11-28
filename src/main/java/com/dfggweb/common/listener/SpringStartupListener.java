package com.dfggweb.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @author dfggking@hotmail.com
 * @date 2017-06-29
 * @version 
 */
public class SpringStartupListener implements ServletContextListener, HttpSessionListener {

    /**
     * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
     * @Description TODO
     * @author dfggking@hotmail.com
     * @date 2017-06-29
     * @version
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // TODO Auto-generated method stub
        System.out.println("sessionCreated");
    }

    /**
     * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
     * @Description TODO
     * @author dfggking@hotmail.com
     * @date 2017-06-29
     * @version
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // TODO Auto-generated method stub
        System.out.println("sessionD");
    }

    /**
     * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
     * @Description TODO
     * @author dfggking@hotmail.com
     * @date 2017-06-29
     * @version
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // TODO Auto-generated method stub
        System.out.println("contextInitialized");
    }

    /**
     * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
     * @Description TODO
     * @author dfggking@hotmail.com
     * @date 2017-06-29
     * @version
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub
        
    }

}
