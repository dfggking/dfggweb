package com.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)//基于Junit4的Spring测试框架  
@ContextConfiguration(locations={"classpath:applicationContext.xml", "classpath:dispatcherServlet.xml"})//启动Spring容器
public class HibernateUtil {
    
    private static SessionFactory sessionFactory;
    
    static {
        try{
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }catch(Throwable ex){
            // TODO: handle exception
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    
    public static void shutdown(){
        getSessionFactory().close();
    }
}
