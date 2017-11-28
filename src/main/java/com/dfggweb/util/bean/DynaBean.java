package com.dfggweb.util.bean;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * 动态bean接口，可以进行设置、获取、遍历、移除、判断、清空属性等操作，还提供了加载实体bean，填充实体bean，复制动态bean的接口。
 * 具体有关属性的信息参照BeanAttributeCopyHelper和BeanAttributeHelper。
 * 
 * @author LiuBo
 * @param <V>
 */
public interface DynaBean<V> {

	/**
	 * 设置属性。
	 * 
	 * @param attributeName
	 *            属性名。
	 * @param value
	 *            属性值。
	 * @return 返回旧的属性值。
	 */
	public V setAttribute(String attributeName, V value);

	/**
	 * 获取属性。
	 * 
	 * @param attributeName
	 *            属性名。
	 * @return 返回属性值。
	 */
	public V getAttribute(String attributeName);

	/**
	 * 包不包含指定名称的属性。
	 * 
	 * @param attributeName
	 *            属性名。
	 * @return 返回是否包含该属性，true包含，false不包含。
	 */
	public boolean containsAttribute(String attributeName);

	/**
	 * 移除属性。
	 * 
	 * @param attributeName
	 *            属性名称。
	 * @return 返回被移除的属性值。
	 */
	public V removeAttribute(String attributeName);

	/**
	 * 获取属性名的set集合，一般用在遍历属性。
	 * 
	 * @return 返回属性名的set集合。
	 */
	public Set<String> keySet();

	/**
	 * 获取所有属性的值。
	 * 
	 * @return 返回所以属性的值。
	 */
	public Collection<V> values();

	/**
	 * 动态bean中属性的个数。
	 * 
	 * @return 属性的个数。
	 */
	public int size();

	/**
	 * 清空所有属性。
	 */
	public void clear();

	/**
	 * 将所有属性复制到指定的动态bean上。
	 * 
	 * @param target
	 *            复制到的动态bean。
	 */
	public void copyTo(DynaBean<V> target);

	/**
	 * 加载指定JavaBean。
	 * 
	 * @param obj
	 *            被加载的JavaBean。
	 * @throws BeanException
	 *             加载错误时抛出异常。
	 */
	public void load(Object obj) throws BeanException;

	/**
	 * 加载指定的JavaBean。复制前属性可以进行类型转换。
	 * 
	 * @param obj
	 *            被加载的JavaBean。
	 * @param convert
	 *            属性类型转换器。
	 * @throws BeanException
	 *             加载错误时抛出异常。
	 */
	public void load(Object obj, BeanAttributeTypeConverter<V> convert) throws BeanException;

	/**
	 * 填充指定的实体bean。
	 * 
	 * @param obj
	 *            被填充的JavaBean。
	 */
	public void fill(Object obj) throws BeanException;

	/**
	 * 填充指定的实体bean。复制前属性可以进行类型转换。
	 * 
	 * @param obj
	 *            被填充的JavaBean。
	 * @param convert
	 *            属性类型转换器。
	 * @throws BeanException
	 *             填充错误时抛出异常。
	 */
	public void fill(Object obj, BeanAttributeTypeConverter<V> convert) throws BeanException;

	/**
	 * 加载指定的map。
	 * 
	 * @param map
	 *            被加载的map。
	 */
	public void load(Map<String, V> map);

	/**
	 * 填充指定的map。
	 * 
	 * @param map
	 *            被填充的map。
	 */
	public void fill(Map<String, V> map);

}
