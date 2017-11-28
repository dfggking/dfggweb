package com.dfggweb.util.bean;

/**
 * JavaBean属性类型的转换接口。
 * 
 * @author LiuBo
 */
public interface BeanAttributeTypeConverter<V> {

	/**
	 * 将值转换成指定的type类型。
	 * 
	 * @param <V>
	 * @param type
	 *            要转换的类型。
	 * @param value
	 *            转换类型的值。
	 * @param attributeName
	 *            属性名称。
	 * @return 返回转换后的值。
	 * @throws BeanException
	 *             转换失败时抛出异常。
	 */
	public V convert(Class<?> type, Object value, String attributeName) throws BeanException;

}
