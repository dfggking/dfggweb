package com.dfggking.common.base.service;

import java.io.Serializable;

public interface IBaseService {

	public <T> T load(Class<T> clazz, Serializable id);

	public <T> T load(String clazz, Serializable id);
	
	public <T> T get(Class<T> clazz, Serializable id);
	
	public <T> T get(String clazz, Serializable id);
	
	public Serializable save(Object arg0);
	
	public Serializable save(String arg0, Object arg1);
	
	public void saveOrUpdate(Object arg0);
	
	public void saveOrUpdate(String arg0, Object arg1);
	
	public void update(Object arg0);
	
	public void update(String arg0, Object arg1);
	
	public void delete(Object arg0);
	
	public void delete(String arg0, Object arg1);
	
}
