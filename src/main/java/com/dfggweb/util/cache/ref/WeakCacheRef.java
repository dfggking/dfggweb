package com.dfggweb.util.cache.ref;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * 弱缓存引用，继承了弱引用WeakReference。
 * 
 * @author LiuBo
 * @param <K>
 * @param <V>
 */
public class WeakCacheRef<K, V> extends WeakReference<V> implements CacheRef<K> {

	/** key */
	private K key;

	/** 参数 */
	private Object params;

	/**
	 * 用指定的对象和引用队列创建WeakCacheRef。
	 * 
	 * @param v
	 *            指定的对象。
	 * @param q
	 *            引用队列。
	 */
	public WeakCacheRef(V v, ReferenceQueue<? super V> q) {
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
