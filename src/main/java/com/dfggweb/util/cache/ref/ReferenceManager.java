package com.dfggweb.util.cache.ref;

import java.lang.ref.ReferenceQueue;

/**
 * 引用管理器。可以获取软引用，弱引用，虚引用。
 * 
 * @author LiuBo
 * @param <K>
 * @param <V>
 */
public class ReferenceManager<K, V> {

	/** 引用队列。 */
	protected ReferenceQueue<? super V> referenceQueue = new ReferenceQueue<V>();

	/**
	 * 获取引用队列。
	 * 
	 * @return
	 */
	public ReferenceQueue<? super V> getReferenceQueue() {
		return referenceQueue;
	}

	/**
	 * 获取软引用，该引用会被加到队列中。
	 * 
	 * @param v
	 *            值。
	 * @return 返回一个软引用。
	 */
	public SoftCacheRef<K, V> getSoftCacheRef(V v) {
		SoftCacheRef<K, V> ret = new SoftCacheRef<K, V>(v, referenceQueue);
		return ret;
	}

	/**
	 * 获取弱引用，该引用会被加到队列中。
	 * 
	 * @param v
	 *            值。
	 * @return 返回一个弱引用。
	 */
	public WeakCacheRef<K, V> getWeakCacheRef(V v) {
		WeakCacheRef<K, V> ret = new WeakCacheRef<K, V>(v, referenceQueue);
		return ret;
	}

	/**
	 * 获取一个虚引用，该引用会被加到队列中。
	 * 
	 * @param v
	 *            值。
	 * @return 返回一个虚引用。
	 */
	public PhantomCacheRef<K, V> getPhantomCacheRef(V v) {
		PhantomCacheRef<K, V> ret = new PhantomCacheRef<K, V>(v, referenceQueue);
		return ret;
	}

}
