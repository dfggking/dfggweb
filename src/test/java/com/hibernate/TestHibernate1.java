package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.cfgxml.spi.CfgXmlAccessService;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.dfggking.sys.domain.DicDO;

public class TestHibernate1 {
	
	public static final ThreadLocal<Session> session = new ThreadLocal<Session>();
	public static SessionFactory SESSION_FACTORY;
	
	// 创建session
	public static Session currentSession(){
		Session s = session.get();
		if(s == null){
			s = SESSION_FACTORY.openSession();
			session.set(s);
		}
		return s;
		
	}
	
	public static void main(String[] args) {
		// 老方法加载
//		Configuration cfg = new Configuration().configure();
//		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
//		SESSION_FACTORY = new Configuration().configure().buildSessionFactory(serviceRegistry);
		
		// 创建sessionFactory 以下 hibernate5.1
		SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
		Transaction tx = currentSession().beginTransaction();
		
		DicDO dic = new DicDO();
		dic.setId("1234");
		dic.setDicName("addByHibernate");
		dic.setDicValue("addByHibernate");
		dic.setParentId("123");
		dic.setDicCode("134556");
		dic.setRemark("11111111");
		dic.setSort("11");
		currentSession().save(dic);
		tx.commit();
		
		SESSION_FACTORY.close();
		
	}
	
}
