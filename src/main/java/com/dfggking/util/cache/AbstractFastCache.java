package com.dfggking.util.cache;

import java.util.List;

/**
 * 缓存的抽象类。引入的缓存加载器。
 * 
 * @author LiuBo
 * @param <K>
 * @param <V>
 */
public abstract class AbstractFastCache<K, V> implements FastCache<K, V> {

	/** 缓存加载器。 */
	protected volatile FastCacheLoader<K, V> fastCacheLoader;

	/**
	 * 默认方式构造缓存。
	 */
	protected AbstractFastCache() {
		;
	}

	/**
	 * 以指定的缓存加载器构造缓存。
	 * 
	 * @param loader
	 *            缓存加载器。
	 */
	protected AbstractFastCache(FastCacheLoader<K, V> loader) {
		fastCacheLoader = loader;
	}

	/**
	 * 用默认的缓存加载器加载缓存。
	 */
	public void load() {
		load(fastCacheLoader);
	}

	public void load(FastCacheLoader<K, V> loader) {
		if (loader == null) {
			return;
		}
		List<FastCacheStore<K, V>> stores = loader.load();
		if (stores == null) {
			return;
		}
		for (FastCacheStore<K, V> store : stores) {
			put(store);
		}
	}

	/**
	 * 获取缓存加载器。
	 * 
	 * @return 缓存加载器。
	 */
	public FastCacheLoader<K, V> getFastCacheLoader() {
		return fastCacheLoader;
	}

	/**
	 * 设置缓存加载器。
	 * 
	 * @param loader
	 *            缓存加载器。
	 */
	public void setFastCacheLoader(FastCacheLoader<K, V> loader) {
		this.fastCacheLoader = loader;
	}

	public V soft(K key, V value) {
		return put(key, value, SOFT);
	}

	public V strong(K key, V value) {
		return put(key, value, STRONG);
	}

	public V weak(K key, V value) {
		return put(key, value, WEAK);
	}

	public V put(FastCacheStore<K, V> store) {
		if (store == null) {
			return null;
		}
		return put(store.getKey(), store.getValue(), store.getCacheType());
	}

	/**
	 * 获取指定键的值，如果没有用默认的缓存加载器获取值。
	 */
	public V get(K key) {
		return get(key, fastCacheLoader);
	}

}
