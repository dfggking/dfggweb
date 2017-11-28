package com.dfggweb.util.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * DynaBean的实现类，增加了克隆和序列化接口。内部采用map封装属性，采用BeanAttributeHelper、BeanAttributeCopyHelper来缓存和复制属性信息。
 * 
 * @author liubo
 * @param <V>
 */
public class DynaBeanImpl<V> implements DynaBean<V>, Serializable, Cloneable {

	private static final long serialVersionUID = -5016912866480999027L;

	/** 存放属性的map */
	protected ConcurrentHashMap<String, V> map = new ConcurrentHashMap<String, V>();

	public void clear() {
		map.clear();
	}

	public boolean containsAttribute(String attributeName) {
		return map.containsKey(attributeName);
	}

	public void copyTo(DynaBean<V> target) {
		Set<String> attributeNames = keySet();
		for (String attributeName : attributeNames) {
			target.setAttribute(attributeName, getAttribute(attributeName));
		}
	}

	public void fill(Object obj) throws BeanException {
		BeanAttributeCopyHelper.copy(map, obj);
	}

	public void fill(Object obj, BeanAttributeTypeConverter<V> convert) throws BeanException {
		BeanAttributeCopyHelper.copy(map, obj, convert);
	}

	public V getAttribute(String attributeName) {
		return map.get(attributeName);
	}

	public Set<String> keySet() {
		return map.keySet();
	}

	public void load(Object obj) throws BeanException {
		BeanAttributeCopyHelper.copy(obj, map);
	}

	public void load(Object obj, BeanAttributeTypeConverter<V> convert) throws BeanException {
		BeanAttributeCopyHelper.copy(obj, map, convert);
	}

	public V removeAttribute(String attributeName) {
		return map.remove(attributeName);
	}

	public V setAttribute(String attributeName, V value) {
		return map.put(attributeName, value);
	}

	public int size() {
		return map.size();
	}

	public Collection<V> values() {
		return map.values();
	}

	public void fill(Map<String, V> map) {
		Set<String> set = this.map.keySet();
		for (String string : set) {
			map.put(string, getAttribute(string));
		}
	}

	public void load(Map<String, V> map) {
		Set<String> set = map.keySet();
		for (String string : set) {
			setAttribute(string, map.get(string));
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof DynaBeanImpl)) {
			return false;
		}
		DynaBeanImpl<V> dynaBean = (DynaBeanImpl<V>) obj;
		return this.map.equals(dynaBean.map);
	}

}
