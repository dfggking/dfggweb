package com.dfggking.util.cache;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

import com.dfggking.util.cache.ref.CacheRef;
import com.dfggking.util.cache.ref.ReferenceManager;


/**
 * Array实现的缓存。实现了FastCache。此类非线程安全。对于元素的增加和减少效率比HashMapCache低，
 * 但利用空间比HashMapCache好。
 * 
 * @author LiuBo
 * @param <K>
 * @param <V>
 */
public class ArrayCache<K, V> extends AbstractFastCache<K, V> {

	/** 引用管理器。 */
	protected final ReferenceManager<K, V> referenceManager = new ReferenceManager<K, V>();

	/** 集合增长和缩小的常量。 */
	protected static final int INCREMENTAL = 0x00000020;

	/** 缓存中元素的个数。 */
	protected int size = 0;

	/** 缓存数据保存的数组。数组长度要大于缓存元素的个数。也就是说cache.length >= size。 */
	protected ArrayCache<?, ?>.KeyValueEntry[] cache = new ArrayCache<?, ?>.KeyValueEntry[INCREMENTAL];

	/** 用来比较两个key的大小。 */
	protected volatile Comparator<K> com;

	/**
	 * 比较两个K谁大谁小，保证null小于非null的key，当两个key不相等，且都不为null的时候，
	 * 调用com来进行比较。这样可以确保调用com不会传入null。
	 */
	protected Comparator<K> comp = new Comparator<K>() {

		public int compare(K o1, K o2) {
			if (o1 == null && o2 != null) {
				return -1;
			}
			if (o1 != null && o2 == null) {
				return 1;
			}
			if (o1 == o2) {
				return 0;
			}
			return com.compare(o1, o2);
		}

	};

	/**
	 * 比较两个ArrayCache.KeyValueEntry的大小。会调用comp来进行比较。
	 */
	protected Comparator<ArrayCache<?, ?>.KeyValueEntry> compp = new Comparator<ArrayCache<?, ?>.KeyValueEntry>() {

		@SuppressWarnings("unchecked")
		public int compare(ArrayCache<?, ?>.KeyValueEntry o1, ArrayCache<?, ?>.KeyValueEntry o2) {
			return comp.compare((K) o1.key, (K) o2.key);
		}

	};

	/**
	 * 以指定的比较器初始化数组缓存，比较器不能为null。比较器确定元素的索引，com.compare(a,b) == 0 意味着 a == b。
	 * 
	 * @param com
	 *            比较器。
	 */
	public ArrayCache(Comparator<K> com) {
		super();
		setComparator(com);
	}

	/**
	 * 以指定的加载器和比较器来初始化数组缓存。比较器不能为null。
	 * 
	 * @param loader
	 *            加载器。
	 * @param com
	 *            比较器。
	 */
	public ArrayCache(FastCacheLoader<K, V> loader, Comparator<K> com) {
		super(loader);
		setComparator(com);
		load();
	}

	/**
	 * 设置比较器。比较器不能为null。会对缓存进行重新排序。
	 * 
	 * @param com
	 *            比较器。
	 */
	public void setComparator(Comparator<K> com) {
		this.com = com;
		if (size > 1) {
			Arrays.sort(cache, 0, size - 1, compp);
		}
	}

	/**
	 * 获取比较器。
	 * 
	 * @return 比较器。
	 */
	public Comparator<K> getComparator() {
		return com;
	}

	/**
	 * 清理引用队列。每当向缓存添加或移除数据的时候会先执行此方法。
	 */
	@SuppressWarnings("unchecked")
	public void clearReferenceQueue() {
		ReferenceQueue<? super V> referenceQueue = referenceManager.getReferenceQueue();
		Reference<?> ref = referenceQueue.poll();
		while (ref != null) {
			if (ref instanceof CacheRef) {
				remove(index(((CacheRef<K>) ref).getKey()));
			}
			ref = referenceQueue.poll();
		}
	}

	public void clear() {
		cache = new ArrayCache.KeyValueEntry[INCREMENTAL];
		size = 0;
		Runtime.getRuntime().gc();
		clearReferenceQueue();
	}

	@SuppressWarnings("unchecked")
	public V get(K key, FastCacheLoader<K, V> loader) {
		V ret = null;
		int index = index(key);
		if (size > index && index >= 0) {
			Object obj = cache[index].value;
			if (obj instanceof Reference) {
				ret = ((Reference<V>) obj).get();
			} else {
				ret = (V) obj;
			}
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
	 * @return 旧的值。
	 */
	@SuppressWarnings("unchecked")
	protected V put(K key, Object obj) {
		V ret = null;
		if (obj instanceof CacheRef) {
			((CacheRef<K>) obj).setKey(key);
		}
		KeyValueEntry kve = new KeyValueEntry();
		kve.key = key;
		kve.value = obj;
		int index = index(key);
		if (size > index && index >= 0) {
			Object old = cache[index].value;
			cache[index] = kve;
			if (old instanceof Reference) {
				ret = ((Reference<V>) old).get();
			} else {
				ret = (V) old;
			}
		} else {
			insert(kve);
		}
		return ret;
	}

	public V remove(K key) {
		clearReferenceQueue();
		return remove(index(key));
	}

	/**
	 * 查找索引，如果没有返回-1，如果有返回索引的位置，本方法采用二分法来查找。
	 * 
	 * @param key
	 *            要查找索引的key。
	 * @return 返回key的索引。
	 */
	@SuppressWarnings("unchecked")
	protected int index(K key) {
		if (size < 1) {
			return -1;
		}
		int index = dichotomy(key);
		return comp.compare(key, (K) cache[index].key) == 0 ? index : -1;
	}

	/**
	 * 二分法查找key的索引。返回最接近的那个索引。当缓存中元素为0时返回索引0，请保证查找时缓存中有数据。
	 * 
	 * @param key
	 *            查找的key。
	 * @return 返回key的索引。
	 */
	@SuppressWarnings("unchecked")
	private int dichotomy(K key) {
		int top = size;
		int bottom = 0;
		int current = (top + bottom) / 2;
		while (top - bottom > 1) {
			if (comp.compare(key, (K) cache[current].key) >= 0) {
				bottom = current;
			} else {
				top = current;
			}
			current = (top + bottom) / 2;
		}
		return current;
	}

	/**
	 * 对调缓存中两个索引位置的元素。
	 * 
	 * @param a
	 *            索引一。
	 * @param b
	 *            索引二。
	 */
	private void swap(int a, int b) {
		ArrayCache<?, ?>.KeyValueEntry t = cache[a];
		cache[a] = cache[b];
		cache[b] = t;
	}

	/**
	 * 想数组中插入一个元素。有则覆盖，没有则插入，插入之后的所有元素是排序的。
	 * 
	 * @param kve
	 *            缓存的一个元素。
	 */
	@SuppressWarnings("unchecked")
	protected void insert(KeyValueEntry kve) {
		if (size < 1) {
			cache[size++] = kve;
		} else {
			ensureCapacity(size + 1);
			K key = (K) kve.key;
			int index = dichotomy(key);
			if (comp.compare(key, (K) cache[index].key) == 0) {
				cache[index] = kve;
			} else {
				int numMoved = size - index;
				for (int i = 0; i < numMoved; i++) {
					swap(size - i, size - i - 1);
				}
				cache[index] = kve;
				if (comp.compare(key, (K) cache[index + 1].key) > 0) {
					swap(index, index + 1);
				}
				size++;
			}
		}
	}

	/**
	 * 确保数组的length > size。
	 * 
	 * @param size
	 *            要确保的大小。
	 */
	protected void ensureCapacity(int size) {
		if (size >= cache.length) {
			int newLength = size + INCREMENTAL;
			ArrayCache<?, ?>.KeyValueEntry[] newCache = new ArrayCache<?, ?>.KeyValueEntry[newLength];
			System.arraycopy(cache, 0, newCache, 0, this.size);
			cache = newCache;
		}
	}

	/**
	 * 移除指定索引上的元素。返回被移除的元素。
	 * 
	 * @param index
	 *            要被移除的索引。
	 * @return 被移除的元素。
	 */
	@SuppressWarnings("unchecked")
	protected V remove(int index) {
		V ret = null;
		if (size > index && index >= 0) {
			Object obj = cache[index].value;
			int numMoved = size - index - 1;
			if (numMoved > 0)
				System.arraycopy(cache, index + 1, cache, index, numMoved);
			cache[--size] = null;
			if (obj instanceof Reference) {
				Reference<V> ref = (Reference<V>) obj;
				ret = ref.get();
				ref.clear();
			} else {
				ret = (V) obj;
			}
		}
		saveSpace();
		return ret;
	}

	/**
	 * 节省空间，适当调整缓存中数组占用内存的大小。
	 */
	protected void saveSpace() {
		if ((cache.length - size) > INCREMENTAL * 2) {
			int newLength = cache.length - INCREMENTAL;
			ArrayCache<?, ?>.KeyValueEntry[] newCache = new ArrayCache<?, ?>.KeyValueEntry[newLength];
			System.arraycopy(cache, 0, newCache, 0, size);
			cache = newCache;
		}
	}

	private KeySet<K> keySet;

	/**
	 * 获取所有键的Set集合。但除了强引用其他引用可能会被回收，这导致在遍历缓存的时候有可能获取到null。
	 * 
	 * @return 返回键的Set集合。
	 */
	public Set<K> keySet() {
		clearReferenceQueue();
		Set<K> ks = keySet;
		return (ks != null ? ks : (keySet = new KeySet<K>()));
	}

	private final class KeySet<E> extends AbstractSet<E> {

		@Override
		public Iterator<E> iterator() {
			return new KeyIterator<E>();
		}

		@Override
		public int size() {
			return ArrayCache.this.size;
		}

		@SuppressWarnings("unchecked")
		@Override
		public boolean contains(Object o) {
			return ArrayCache.this.index((K) o) >= 0;
		}

		@SuppressWarnings("unchecked")
		@Override
		public boolean remove(Object o) {
			ArrayCache.this.remove(ArrayCache.this.index((K) o));
			return true;
		}

		@Override
		public void clear() {
			ArrayCache.this.clear();
		}
	}

	private class KeyIterator<E> implements Iterator<E> {

		private int index;

		private E current;

		public boolean hasNext() {
			return index < size;
		}

		@SuppressWarnings("unchecked")
		public E next() {
			current = (E) cache[index++].key;
			return current;
		}

		@SuppressWarnings("unchecked")
		public void remove() {
			if (current == null) {
				throw new IllegalStateException();
			}
			ArrayCache.this.remove(ArrayCache.this.index((K) current));
			current = null;
		}

	}

	/**
	 * 缓存中元素的个数。但除了强引用其他引用可能会被回收，这导致在遍历缓存的时候有可能获取到null。
	 * 
	 * @return 元素的个数。
	 */
	public int size() {
		return size;
	}

	/**
	 * 缓存是否为空。但除了强引用其他引用可能会被回收，这导致在遍历缓存的时候有可能获取到null。
	 * 
	 * @return 返回缓存是否为空。
	 */
	public boolean isEmpty() {
		return size <= 0;
	}

	@Override
	protected void finalize() throws Throwable {
		clear();
		super.finalize();
	}

	/**
	 * 缓存键和值的实体类。
	 * 
	 * @author liubo
	 */
	protected class KeyValueEntry {

		/** 缓存的键。 */
		public Object key;

		/** 缓存的值。 */
		public Object value;
	}

}
