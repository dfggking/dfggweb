package com.dfggweb.util.cache;

import java.util.Set;

/**
 * 缓存提供缓存接口，加入、移除、获取、清理缓存。提供了三种缓存，强引用、软引用、弱引用，可根据需求来缓存。
 * 强引用被引用时不会被回收，软引用当内存不足时可能被回收，弱引用等待回收的引用且很容易被回收。 三种引用从生命周期上区分，强引用>软引用>弱引用。
 * 注意：请不要保存缓存的任何内容的引用，这样会影响垃圾回收期对对象的回收。比如说String池等等，最好New一个对象放到缓存中。
 * 
 * @author LiuBo
 * @param <K>
 * @param <V>
 */
public interface FastCache<K, V> {

	/** 强引用 */
	public static int STRONG = 0x00000001;

	/** 软引用 */
	public static int SOFT = 0x00000002;

	/** 弱引用 */
	public static int WEAK = 0x00000004;

	/**
	 * 将制定的键和值以强引用的形式缓存。
	 * 
	 * @param key
	 *            键。
	 * @param value
	 *            值。
	 * @return 返回旧的值。
	 */
	public V strong(K key, V value);

	/**
	 * 将指定键和值以软引用的形式缓存。
	 * 
	 * @param key
	 *            键。
	 * @param value
	 *            值。
	 * @return 返回旧的值。
	 */
	public V soft(K key, V value);

	/**
	 * 将指定的键和值以弱引用的形式缓存。
	 * 
	 * @param key
	 *            键。
	 * @param value
	 *            值。
	 * @return 返回旧的值。
	 */
	public V weak(K key, V value);

	/**
	 * 将键和值以指定的形式缓存起来。
	 * 
	 * @param key
	 *            键。
	 * @param value
	 *            值。
	 * @param cacheType
	 *            缓存的方式。
	 * @return 返回旧的值。
	 */
	public V put(K key, V value, int cacheType);

	/**
	 * 将指定的包装起来的键和值缓存起来。
	 * 
	 * @param store
	 *            包装的缓存信息。
	 * @return 旧的值。
	 */
	public V put(FastCacheStore<K, V> store);

	/**
	 * 移除指定的键，还会移除对应的值。
	 * 
	 * @param key
	 *            键。
	 * @return 返回移除的值。
	 */
	public V remove(K key);

	/**
	 * 获得指定键的值。
	 * 
	 * @param key
	 *            键。
	 * @return 返回对应的值。
	 */
	public V get(K key);

	/**
	 * 获得指定键的值。如果没有缓存可以利用加载器来获取。
	 * 
	 * @param key
	 *            键。
	 * @param loader
	 *            加载器。
	 * @return 返回对应的值。
	 */
	public V get(K key, FastCacheLoader<K, V> loader);

	/**
	 * 清空缓存，所有内容都将被移除。
	 */
	public void clear();

	/**
	 * 加载缓存。
	 */
	public void load();

	/**
	 * 用指定的加载器加载缓存。
	 * 
	 * @param loader
	 *            加载器。
	 */
	public void load(FastCacheLoader<K, V> loader);

	/**
	 * 获取所有键的Set集合。但除了强引用其他引用可能会被回收，这导致在遍历缓存的时候有可能获取到null。
	 * 
	 * @return 返回键的Set集合。
	 */
	public Set<K> keySet();

	/**
	 * 是不是空缓存。但除了强引用其他引用可能会被回收，这导致缓存不为空但获取到的元素都为null。
	 * 
	 * @return 空返回true，否则返回false。
	 */
	public boolean isEmpty();

	/**
	 * 缓存中元素的个数。但除了强引用其他引用可能会被回收，这导致在遍历缓存的时候有可能获取到null。
	 * 
	 * @return 元素的个数。
	 */
	public int size();
	
	/**
	 * 获取默认缓存加载器。
	 * 
	 * @return 缓存加载器。
	 */
	public FastCacheLoader<K, V> getFastCacheLoader();
	
	/**
	 * 设置默认缓存加载器。
	 * 
	 * @param loader
	 *            缓存加载器。
	 */
	public void setFastCacheLoader(FastCacheLoader<K, V> loader);

}
