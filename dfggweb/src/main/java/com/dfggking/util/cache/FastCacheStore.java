package com.dfggking.util.cache;

/**
 * 缓存的一条数据。
 * 
 * @author LiuBo
 * @param <K>
 * @param <V>
 */
public class FastCacheStore<K, V> {

	/** 键 */
	private K key;

	/** 值 */
	private V value;

	/** 缓存类型 */
	private int cacheType;

	/**
	 * 获取缓存类型。参考FastCache接口等。
	 * 
	 * @return 缓存类型。
	 */
	public int getCacheType() {
		return cacheType;
	}

	/**
	 * 设置缓存类型。参考FastCache接口等。
	 * 
	 * @param cacheType
	 *            缓存类型。
	 */
	public void setCacheType(int cacheType) {
		this.cacheType = cacheType;
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
	 * 获取值。
	 * 
	 * @return 值。
	 */
	public V getValue() {
		return value;
	}

	/**
	 * 设置值。
	 * 
	 * @param value
	 *            值。
	 */
	public void setValue(V value) {
		this.value = value;
	}

}
