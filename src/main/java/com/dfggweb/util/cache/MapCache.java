package com.dfggweb.util.cache;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.dfggweb.util.cache.ref.CacheRef;
import com.dfggweb.util.cache.ref.ReferenceManager;


/**
 * Map实现的缓存。实现了FastCache。此类非线程安全。
 * 
 * @author LiuBo
 * @param <K>
 * @param <V>
 */
public class MapCache<K, V> extends AbstractFastCache<K, V> {

	/** 引用管理器。 */
	protected final ReferenceManager<K, V> referenceManager = new ReferenceManager<K, V>();

	/** 缓存Map。 */
	protected Map<K, Object> cache;

	/**
	 * 默认方式构造MapCache。
	 */
	public MapCache() {
		this(new ConcurrentHashMap<K, Object>());
	}

	/**
	 * 以指定的Map构造MapCache。
	 * 
	 * @param cache
	 */
	public MapCache(Map<K, Object> cache) {
		super();
		this.cache = cache;
	}

	/**
	 * 以指定缓存加载器构造MapCache。
	 * 
	 * @param loader
	 *            缓存加载器。
	 */
	public MapCache(FastCacheLoader<K, V> loader) {
		this(loader, new ConcurrentHashMap<K, Object>());
	}

	/**
	 * 以指定缓存加载器和Map构造MapCache。
	 * 
	 * @param loader
	 * @param cache
	 */
	public MapCache(FastCacheLoader<K, V> loader, Map<K, Object> cache) {
		super(loader);
		load();
		this.cache = cache;
	}

	/**
	 * 清理引用队列。每当向缓存添加或移除数据的时候会先执行此方法。
	 */
	public void clearReferenceQueue() {
		ReferenceQueue<? super V> referenceQueue = referenceManager.getReferenceQueue();
		Reference<?> ref = referenceQueue.poll();
		while (ref != null) {
			if (ref instanceof CacheRef) {
				cache.remove(((CacheRef<?>) ref).getKey());
			}
			ref = referenceQueue.poll();
		}
	}

	public void clear() {
		cache.clear();
		clearReferenceQueue();
	}

	@SuppressWarnings("unchecked")
	public V get(K key, FastCacheLoader<K, V> loader) {
		V ret = null;
		Object obj = cache.get(key);
		if (obj instanceof Reference) {
			ret = ((Reference<V>) obj).get();
		} else {
			ret = (V) obj;
		}
		if (ret == null) {
			if (loader != null) {
				FastCacheStore<K, V> store = loader.load(key);
				if (store != null) {
					ret = store.getValue();
					put(store);
				}
			}
		}
		return ret;
	}

	public V put(K key, V value, int cacheType) {
		clearReferenceQueue();
		switch (cacheType) {
		case STRONG:
			return put(key, value);
		case SOFT:
			return put(key, referenceManager.getSoftCacheRef(value));
		case WEAK:
			return put(key, referenceManager.getWeakCacheRef(value));
		default:
			throw new IllegalArgumentException("Error cacheType (" + cacheType + ")");
		}
	}

	/**
	 * 将指定的键和值添加到缓存中。所有添加缓存最终都将调用此方法。
	 * 
	 * @param key
	 *            键。
	 * @param obj
	 *            值。
	 * @return 返回旧的值。
	 */
	@SuppressWarnings("unchecked")
	protected V put(K key, Object obj) {
		V ret = null;
		if (obj instanceof CacheRef) {
			((CacheRef<K>) obj).setKey(key);
		}
		Object old = cache.put(key, obj);
		if (old instanceof Reference) {
			ret = ((Reference<V>) old).get();
		} else {
			ret = (V) old;
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	public V remove(K key) {
		clearReferenceQueue();
		V ret = null;
		Object obj = cache.remove(key);
		if (obj instanceof Reference) {
			Reference<V> ref = (Reference<V>) obj;
			ret = ref.get();
			ref.clear();
		} else {
			ret = (V) obj;
		}
		return ret;
	}

	/**
	 * 获取所有键的Set集合。但除了强引用其他引用可能会被回收，这导致在遍历缓存的时候有可能获取到null。
	 * 
	 * @return 返回键的Set集合。
	 */
	public Set<K> keySet() {
		clearReferenceQueue();
		return cache.keySet();
	}

	/**
	 * 是不是空缓存。但除了强引用其他引用可能会被回收，这导致缓存不为空但获取到的元素都为null。
	 * 
	 * @return 空返回true，否则返回false。
	 */
	public boolean isEmpty() {
		clearReferenceQueue();
		return cache.isEmpty();
	}

	/**
	 * 返回缓存的大小。但除了强引用其他引用可能会被回收，这导致缓存中虽然有一些引用但是里面的引用有可能为null。
	 * 
	 * @return 缓存大小即缓存中元素的个数。
	 */
	public int size() {
		clearReferenceQueue();
		return cache.size();
	}

	@Override
	protected void finalize() throws Throwable {
		clear();
		super.finalize();
	}

}
