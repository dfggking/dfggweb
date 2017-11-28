package com.dfggweb.util.cache;

import java.util.List;

/**
 * 缓存加载器。
 * 
 * @author LiuBo
 * @param <K>
 * @param <V>
 */
public interface FastCacheLoader<K, V> {

	/**
	 * 加载缓存数据。返回一个装有缓存数据的集合。请保证返回的Store中的内容正确。
	 * 
	 * @return 返回一个装有缓存数据的集合。
	 */
	public List<FastCacheStore<K, V>> load();

	/**
	 * 加载指定键的缓存数据。请保证返回的Store中的内容正确。
	 * 
	 * @param key
	 *            键。
	 * @return 返回一条缓存数据。
	 */
	public FastCacheStore<K, V> load(K key);

}
