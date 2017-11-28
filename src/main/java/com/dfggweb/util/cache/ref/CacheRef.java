package com.dfggweb.util.cache.ref;

/**
 * 缓存引用接口，提供键和参数两个属性。
 * 
 * @author LiuBo
 * @param <K>
 */
public interface CacheRef<K> {

	/**
	 * 获取键。
	 * 
	 * @return 键。
	 */
	public K getKey();

	/**
	 * 设置键。
	 * 
	 * @param key
	 *            键。
	 */
	public void setKey(K key);

	/**
	 * 获取参数。
	 * 
	 * @return 返回参数。
	 */
	public Object getParams();

	/**
	 * 设置参数。
	 * 
	 * @param params
	 *            参数。
	 */
	public void setParams(Object params);
}
