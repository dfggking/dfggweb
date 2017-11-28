package com.dfggweb.util.cache.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚缓存引用，继承了虚引用PhantomReference。
 * 
 * @author LiuBo
 * @param <K>
 * @param <V>
 */
public class PhantomCacheRef<K, V> extends PhantomReference<V> implements CacheRef<K> {

	/** key */
	private K key;

	/** 参数 */
	private Object params;

	/**
	 * 用指定的对象和引用队列创建PhantomCacheRef。
	 * 
	 * @param v
	 *            指定的对象。
	 * @param q
	 *            引用队列。
	 */
	public PhantomCacheRef(V v, ReferenceQueue<? super V> q) {
		super(v, q);
	}

	/**
	 * 获取键。
	 * 
	 * @return 键。
	 */
	public K getKey() {
		return key;
	}

	/**
	 * 设置键。
	 * 
	 * @param key
	 *            键。
	 */
	public void setKey(K key) {
		this.key = key;
	}

	/**
	 * 获取参数。
	 * 
	 * @return 返回参数。
	 */
	public Object getParams() {
		return params;
	}

	/**
	 * 设置参数。
	 * 
	 * @param params
	 *            参数。
	 */
	public void setParams(Object params) {
		this.params = params;
	}

}
