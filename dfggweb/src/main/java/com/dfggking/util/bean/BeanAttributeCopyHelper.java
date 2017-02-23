package com.dfggking.util.bean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/**
 * 拷贝JavaBean属性的帮助类，支持从JavaBean拷贝到JavaBean、Map拷贝到JavaBean、JavaBean拷贝到Map，支持属性之间的转换。
 * 
 * @author LiuBo
 */
public abstract class BeanAttributeCopyHelper {

	/**
	 * 将p的属性拷贝到r中。
	 * 
	 * @param <E>
	 * @param <R>
	 * @param p
	 *            被拷贝的JavaBean。
	 * @param r
	 *            拷贝到的JavaBean。
	 * @return 返回拷贝后的JavaBean，即r。
	 * @throws BeanException
	 *             拷贝失败时抛出异常。
	 */
	public static <E, R> R copy(E p, R r) throws BeanException {
		return copy(p, r, null);
	}

	/**
	 * 将p的属性拷贝到r中，通过convert来进行拷贝前的类型转换。
	 * 
	 * @param <E>
	 * @param <R>
	 * @param p
	 *            被拷贝的JavaBean。
	 * @param r
	 *            拷贝到的JavaBean。
	 * @param convert
	 *            属性的类型转换器。
	 * @return 返回拷贝后的JavaBean，即r。
	 * @throws BeanException
	 *             拷贝失败时抛出异常。
	 */
	public static <E, R> R copy(E p, R r, BeanAttributeTypeConverter<?> convert) throws BeanException {
		Map<String, BeanAttribute> pAttributes = BeanAttributeHelper.getBeanAttributes(p);
		Map<String, BeanAttribute> rAttributes = BeanAttributeHelper.getBeanAttributes(r);
		Set<String> set = pAttributes.keySet();
		for (String string : set) {
			BeanAttribute pAttribute = pAttributes.get(string);
			BeanAttribute rAttribute = rAttributes.get(string);
			copyAttribute(p, r, pAttribute, rAttribute, convert);
		}
		return r;
	}

	/**
	 * 将p的属性拷贝到r中，通过convert来进行拷贝前的类型转换，通过attributeNames来执行需要转换的属性名称。
	 * 
	 * @param <E>
	 * @param <R>
	 * @param p
	 *            被拷贝的JavaBean。
	 * @param r
	 *            拷贝到的JavaBean。
	 * @param convert
	 *            属性的类型转换器。
	 * @param attributeNames
	 *            需要被拷贝的属性名称。
	 * @return 返回拷贝后的JavaBean，即r。
	 * @throws BeanException
	 *             拷贝失败时抛出异常。
	 */
	public static <E, R> R copy(E p, R r, BeanAttributeTypeConverter<?> convert, String... attributeNames)
			throws BeanException {
		Map<String, BeanAttribute> pAttributes = BeanAttributeHelper.getBeanAttributes(p);
		Map<String, BeanAttribute> rAttributes = BeanAttributeHelper.getBeanAttributes(r);
		for (String string : attributeNames) {
			BeanAttribute pAttribute = pAttributes.get(string);
			BeanAttribute rAttribute = rAttributes.get(string);
			copyAttribute(p, r, pAttribute, rAttribute, convert);
		}
		return r;
	}

	/**
	 * 将p的属性拷贝到r中。
	 * 
	 * @param <E>
	 * @param <V>
	 * @param p
	 *            被拷贝的JavaBean。
	 * @param r
	 *            拷贝到的Map。
	 * @return 返回拷贝后的Map，即r。
	 * @throws BeanException
	 *             拷贝失败时抛出异常。
	 */
	public static <E, V> Map<String, V> copy(E p, Map<String, V> r) throws BeanException {
		return copy(p, r, null);
	}

	/**
	 * 将p的属性拷贝到r中，通过convert来进行拷贝前的类型转换。
	 * 
	 * @param <E>
	 * @param <V>
	 * @param p
	 *            被拷贝的JavaBean。
	 * @param r
	 *            拷贝到的Map。
	 * @param convert
	 *            属性的类型转换器。
	 * @return 返回拷贝后的Map，即r。
	 * @throws BeanException
	 *             拷贝失败时抛出异常。
	 */
	public static <E, V> Map<String, V> copy(E p, Map<String, V> r, BeanAttributeTypeConverter<V> convert)
			throws BeanException {
		Map<String, BeanAttribute> pAttributes = BeanAttributeHelper.getBeanAttributes(p);
		Set<String> set = pAttributes.keySet();
		for (String string : set) {
			BeanAttribute pAttribute = pAttributes.get(string);
			copyAttribute(p, r, pAttribute, convert);
		}
		return r;
	}

	/**
	 * 将p的属性拷贝到r中，通过convert来进行拷贝前的类型转换,通过attributeNames来执行需要转换的属性名称。
	 * 
	 * @param <E>
	 * @param <V>
	 * @param p
	 *            被拷贝的JavaBean。
	 * @param r
	 *            拷贝到的Map。
	 * @param convert
	 *            属性的类型转换器。
	 * @param attributeNames
	 *            需要被拷贝的属性名称。
	 * @return 返回拷贝后的Map，即r。
	 * @throws BeanException
	 *             拷贝失败时抛出异常。
	 */
	public static <E, V> Map<String, V> copy(E p, Map<String, V> r, BeanAttributeTypeConverter<V> convert,
			String... attributeNames) throws BeanException {
		Map<String, BeanAttribute> pAttributes = BeanAttributeHelper.getBeanAttributes(p);
		for (String string : attributeNames) {
			BeanAttribute pAttribute = pAttributes.get(string);
			copyAttribute(p, r, pAttribute, convert);
		}
		return r;
	}

	/**
	 * 将p的属性拷贝到r中。
	 * 
	 * @param <R>
	 * @param <V>
	 * @param p
	 *            被拷贝的Map。
	 * @param r
	 *            拷贝到的JavaBean。
	 * @return 返回拷贝后的JavaBean，即r。
	 * @throws BeanException
	 *             拷贝失败时抛出异常。
	 */
	public static <R, V> R copy(Map<String, V> p, R r) throws BeanException {
		return copy(p, r, null);
	}

	/**
	 * 将p的属性拷贝到r中，通过convert来进行拷贝前的类型转换。
	 * 
	 * @param <R>
	 * @param <V>
	 * @param p
	 *            被拷贝的Map。
	 * @param r
	 *            拷贝到的JavaBean。
	 * @param convert
	 *            属性的类型转换器。
	 * @return 返回拷贝后的JavaBean，即r。
	 * @throws BeanException
	 *             拷贝失败时抛出异常。
	 */
	public static <R, V> R copy(Map<String, V> p, R r, BeanAttributeTypeConverter<?> convert) throws BeanException {
		Map<String, BeanAttribute> rAttributes = BeanAttributeHelper.getBeanAttributes(r);
		Set<String> set = p.keySet();
		for (String string : set) {
			BeanAttribute rAttribute = rAttributes.get(string);
			copyAttribute(p, r, rAttribute, convert);
		}
		return r;
	}

	/**
	 * 将p的属性拷贝到r中，通过convert来进行拷贝前的类型转换,通过attributeNames来执行需要转换的属性名称。
	 * 
	 * @param <R>
	 * @param <V>
	 * @param p
	 *            被拷贝的Map。
	 * @param r
	 *            拷贝到的JavaBean。
	 * @param convert
	 *            属性的类型转换器。
	 * @param attributeNames
	 *            需要被拷贝的属性名称。
	 * @return 返回拷贝后的JavaBean，即r。
	 * @throws BeanException
	 *             拷贝失败时抛出异常。
	 */
	public static <R, V> R copy(Map<String, V> p, R r, BeanAttributeTypeConverter<?> convert, String... attributeNames)
			throws BeanException {
		Map<String, BeanAttribute> rAttributes = BeanAttributeHelper.getBeanAttributes(r);
		for (String string : attributeNames) {
			BeanAttribute rAttribute = rAttributes.get(string);
			copyAttribute(p, r, rAttribute, convert);
		}
		return r;
	}

	/**
	 * 将p的pAttribute属性拷贝到r的rAttribute属性中，通过convert来进行拷贝前的类型转换。
	 * 
	 * @param <E>
	 * @param <R>
	 * @param p
	 *            被拷贝的JavaBean。
	 * @param r
	 *            拷贝到的JavaBean。
	 * @param pAttribute
	 *            被拷贝的属性信息。
	 * @param rAttribute
	 *            拷贝到的属性信息。
	 * @param convert
	 *            属性的类型转换器。
	 * @return 返回拷贝结果，true成功，false失败。
	 * @throws BeanException
	 *             拷贝失败时抛出异常。
	 */
	private static <E, R> boolean copyAttribute(E p, R r, BeanAttribute pAttribute, BeanAttribute rAttribute,
			BeanAttributeTypeConverter<?> convert) throws BeanException {
		if (pAttribute == null || rAttribute == null) {
			return false;
		}
		Method getMethod = pAttribute.getGetMethod();
		Method setMethod = rAttribute.getSetMethod();
		if (getMethod == null || setMethod == null) {
			return false;
		}
		try {
			Object param = getMethod.invoke(p, new Object[] {});
			if (convert != null) {
				param = convert.convert(rAttribute.getAttributeClazz(), param, rAttribute.getAttributeName());
			}
			setMethod.invoke(r, new Object[] { param });
		} catch (IllegalArgumentException e) {
			throw new BeanException(e);
		} catch (IllegalAccessException e) {
			throw new BeanException(e);
		} catch (InvocationTargetException e) {
			throw new BeanException(e);
		}
		return true;
	}

	/**
	 * 将p中的pAttribute属性拷贝到r中，通过convert来进行拷贝前的类型转换。
	 * 
	 * @param <E>
	 * @param <V>
	 * @param p
	 *            被拷贝的JavaBean。
	 * @param r
	 *            拷贝到的Map。
	 * @param pAttribute
	 *            被拷贝的属性信息。
	 * @param convert
	 *            属性的类型转换器。
	 * @return 返回拷贝结果，true成功，false失败。
	 * @throws BeanException
	 *             拷贝失败时抛出异常。
	 */
	@SuppressWarnings("unchecked")
	private static <E, V> boolean copyAttribute(E p, Map<String, V> r, BeanAttribute pAttribute,
			BeanAttributeTypeConverter<V> convert) throws BeanException {
		if (pAttribute == null) {
			return false;
		}
		Method getMethod = pAttribute.getGetMethod();
		if (getMethod == null) {
			return false;
		}
		try {
			Object param = getMethod.invoke(p, new Object[] {});
			if (convert != null) {
				param = convert.convert(Object.class, param, pAttribute.getAttributeName());
			}
			r.put(pAttribute.getAttributeName(), (V) param);
		} catch (IllegalArgumentException e) {
			throw new BeanException(e);
		} catch (IllegalAccessException e) {
			throw new BeanException(e);
		} catch (InvocationTargetException e) {
			throw new BeanException(e);
		}
		return true;
	}

	/**
	 * 将p中的属性拷贝到r中的rAttribute属性，通过convert来进行拷贝前的类型转换。
	 * 
	 * @param <R>
	 * @param <V>
	 * @param p
	 *            被拷贝的Map。
	 * @param r
	 *            拷贝到的JavaBean。
	 * @param rAttribute
	 *            拷贝到的属性信息。
	 * @param convert
	 *            属性的类型转换器。
	 * @return 返回拷贝结果，true成功，false失败。
	 * @throws BeanException
	 *             拷贝失败时抛出异常。
	 */
	private static <R, V> boolean copyAttribute(Map<String, V> p, R r, BeanAttribute rAttribute,
			BeanAttributeTypeConverter<?> convert) throws BeanException {
		if (rAttribute == null) {
			return false;
		}
		Method setMethod = rAttribute.getSetMethod();
		if (setMethod == null) {
			return false;
		}
		Object param = p.get(rAttribute.getAttributeName());
		if (convert != null) {
			param = convert.convert(rAttribute.getAttributeClazz(), param, rAttribute.getAttributeName());
		}
		try {
			setMethod.invoke(r, new Object[] { param });
		} catch (IllegalArgumentException e) {
			throw new BeanException(e);
		} catch (IllegalAccessException e) {
			throw new BeanException(e);
		} catch (InvocationTargetException e) {
			throw new BeanException(e);
		}
		return true;
	}

}
