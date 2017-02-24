package com.dfggking.common.base.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dfggking.common.base.service.IBaseService;
import com.dfggking.common.dao.HibernateDao;

public class BaseServiceImpl implements IBaseService {
	
	private final static Logger log = LogManager.getLogger(BaseServiceImpl.class);
	@Resource
	protected HibernateDao hdao;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class, isolation = Isolation.READ_COMMITTED)
	public <T> T load(Class<T> clazz, Serializable id){
		return hdao.load(clazz, id);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class, isolation = Isolation.READ_COMMITTED)
	public <T> T load(String clazz, Serializable id){
		return hdao.load(clazz, id);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class, isolation = Isolation.READ_COMMITTED)
	public <T> T get(Class<T> clazz, Serializable id){
		return hdao.get(clazz, id);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class, isolation = Isolation.READ_COMMITTED)
	public <T> T get(String clazz, Serializable id){
		return hdao.get(clazz, id);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class, isolation = Isolation.READ_COMMITTED)
	public Serializable save(Object arg0){
		return hdao.save(arg0);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class, isolation = Isolation.READ_COMMITTED)
	public Serializable save(String arg0, Object arg1){
		return hdao.save(arg0, arg1);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class, isolation = Isolation.READ_COMMITTED)
	public void saveOrUpdate(Object arg0){
		hdao.saveOrUpdate(arg0);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class, isolation = Isolation.READ_COMMITTED)
	public void saveOrUpdate(String arg0, Object arg1){
		hdao.saveOrUpdate(arg0, arg1);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class, isolation = Isolation.READ_COMMITTED)
	public void update(Object arg0){
		hdao.update(arg0);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class, isolation = Isolation.READ_COMMITTED)
	public void update(String arg0, Object arg1){
		hdao.update(arg0, arg1);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class, isolation = Isolation.READ_COMMITTED)
	public void delete(Object arg0){
		hdao.delete(arg0);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class, isolation = Isolation.READ_COMMITTED)
	public void delete(String arg0, Object arg1){
		hdao.delete(arg0, arg1);
	}
}
