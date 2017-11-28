package com.dfggweb.util.bean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dfggweb.util.cache.FastCache;
import com.dfggweb.util.cache.FastCacheStore;
import com.dfggweb.util.cache.MapCache;


/**
 * JavaBean属性的帮助类。解析JavaBean的属性信息，缓存JavaBean的属性信息，设置、获取JavaBean的属性，支持多层。
 * 
 * @author LiuBo
 */
public abstract class BeanAttributeHelper {

	/** 缓存JavaBean属性信息 */
	protected static final MapCache<Class<?>, HashMap<String, BeanAttribute>> BEANATTRIBUTECACHE = new MapCache<Class<?>, HashMap<String, BeanAttribute>>();

	public static String correctAttributeName(String name) {
		return (Character.toLowerCase(name.charAt(0)) + name.substring(1));
	}

	/**
	 * 解析obj的属性信息。被解析的obj不得是抽象类、接口；静态、抽象，天生的，getClass函数将不被解析；同一个属性的set、get函数要具有相同的类型。
	 * 
	 * @param obj
	 *            被解析的Object。
	 * @return 返回解析后的属性信息数组。
	 * @throws BeanException
	 *             解析失败时抛出异常。
	 */
	public static BeanAttribute[] parse(Object obj) throws BeanException {
		return parse(obj.getClass());
	}

	/**
	 * 解析clazz的属性信息。被解析的clazz不得是抽象类、接口；静态、抽象，天生的，getClass函数将不被解析；同一个属性的set、get函数要具有相同的类型。
	 * 
	 * @param clazz
	 *            被解析的clazz。
	 * @return 返回解析后的属性信息数组。
	 * @throws BeanException
	 *             解析失败时抛出异常。
	 */
	public static BeanAttribute[] parse(Class<?> clazz) throws BeanException {
		int modifier = clazz.getModifiers();
		if (Modifier.isAbstract(modifier) || Modifier.isInterface(modifier)) {
			throw new BeanException(clazz.getName() + " is abstract or interface.");
		}
		Method[] methods = clazz.getMethods();
		List<BeanAttribute> list = new ArrayList<BeanAttribute>();
		for (Method method : methods) {
			if (!checkMethod(method)) {
				continue;
			}
			String methodName = method.getName();
			if (methodName.startsWith("set") && methodName.length() > 3 && method.getParameterTypes().length == 1
					&& method.getReturnType().getName() == "void" && Character.isUpperCase(methodName.charAt(3))) {
				BeanAttribute beanAttribute = findBeanAttributeAboutGetMethod(list, method);
				if (beanAttribute == null) {
					beanAttribute = new BeanAttribute();
					beanAttribute.setAttributeName(correctAttributeName(method.getName().substring(3)));
					beanAttribute.setAttributeClazz(method.getParameterTypes()[0]);
					beanAttribute.setSetMethod(method);
					list.add(beanAttribute);
				} else {
					beanAttribute.setSetMethod(method);
				}
				continue;
			}
			if (methodName.startsWith("get") && methodName.length() > 3 && method.getParameterTypes().length == 0
					&& method.getReturnType().getName() != "void" && Character.isUpperCase(methodName.charAt(3))) {
				BeanAttribute beanAttribute = findBeanAttributeAboutSetMethod(list, method);
				if (beanAttribute == null) {
					beanAttribute = new BeanAttribute();
					beanAttribute.setAttributeName(correctAttributeName(method.getName().substring(3)));
					beanAttribute.setAttributeClazz(method.getReturnType());
					beanAttribute.setGetMethod(method);
					list.add(beanAttribute);
				} else {
					beanAttribute.setGetMethod(method);
				}
			}
		}
		BeanAttribute[] ret = new BeanAttribute[list.size()];
		return list.toArray(ret);
	}

	/**
	 * 检查method是否符合要求，不能使静态、抽象、天生的方法，也不能是getClass方法。
	 * 
	 * @param method
	 *            被检查的方法。
	 * @return 返回检查结果，true通过，false不通过。
	 */
	private static boolean checkMethod(Method method) {
		int modifier = method.getModifiers();
		if (Modifier.isStatic(modifier)) {
			return false;
		}
		if (Modifier.isAbstract(modifier)) {
			return false;
		}
		if (Modifier.isNative(modifier)) {
			return false;
		}
		if (method.getName().equals("getClass")) {
			return false;
		}
		return true;
	}

	/**
	 * 查找是否有对应get方法，返回有get方法的BeanAttribute。
	 * 
	 * @param list
	 *            被查找的集合。
	 * @param method
	 *            与之对应的method。
	 * @return 返回对应的BeanAttribute，没有返回null。
	 * @throws BeanException
	 *             检查错误时抛出异常。
	 */
	private static BeanAttribute findBeanAttributeAboutGetMethod(List<BeanAttribute> list, Method method)
			throws BeanException {
		for (BeanAttribute beanAttribute : list) {
			Method getMethod = beanAttribute.getGetMethod();
			if (getMethod != null) {
				if (correctAttributeName(method.getName().substring(3)).equals(beanAttribute.getAttributeName())) {
					if (method.getParameterTypes()[0].equals(getMethod.getReturnType())) {
						return beanAttribute;
					} else {
						throw new BeanException("AttributeName[" + beanAttribute.getAttributeName()
								+ "] set's ParameterTypes != get's ReturnType");
					}
				}
			}
		}
		return null;
	}

	/**
	 * 查找是否有对象的set方法，返回有set方法的BeanAttribute。
	 * 
	 * @param list
	 *            被查找的集合。
	 * @param method
	 *            与之对应的method。
	 * @return 返回对应的BeanAttribute，没有返回null。
	 * @throws BeanException
	 *             检查错误时抛出异常。
	 */
	private static BeanAttribute findBeanAttributeAboutSetMethod(List<BeanAttribute> list, Method method)
			throws BeanException {
		for (BeanAttribute beanAttribute : list) {
			Method setMethod = beanAttribute.getSetMethod();
			if (setMethod != null) {
				if (correctAttributeName(method.getName().substring(3)).equals(beanAttribute.getAttributeName())) {
					if (method.getReturnType().equals(setMethod.getParameterTypes()[0])) {
						return beanAttribute;
					} else {
						throw new BeanException("AttributeName[" + beanAttribute.getAttributeName()
								+ "] set's ParameterTypes != get's ReturnType");
					}
				}
			}
		}
		return null;
	}

	/**
	 * 获取类的属性信息，如何解析请参照parse方法。
	 * 
	 * @param clazz
	 *            类类型。
	 * @return 返回类的属性信息。
	 */
	public static Map<String, BeanAttribute> getBeanAttributes(Class<?> clazz) throws BeanException {
		Map<String, BeanAttribute> ret = BEANATTRIBUTECACHE.get(clazz, null);
		if (ret == null) {
			HashMap<String, BeanAttribute> value = new HashMap<String, BeanAttribute>();
			BeanAttribute[] beanAttributes = parse(clazz);
			for (BeanAttribute beanAttribute : beanAttributes) {
				value.put(beanAttribute.getAttributeName(), beanAttribute);
			}
			FastCacheStore<Class<?>, HashMap<String, BeanAttribute>> store = new FastCacheStore<Class<?>, HashMap<String, BeanAttribute>>();
			store.setKey(clazz);
			store.setValue(value);
			store.setCacheType(FastCache.SOFT);
			BEANATTRIBUTECACHE.put(store);
			ret = value;
		}
		return ret;
	}

	/**
	 * 获取对象的属性信息，如何解析请参照parse方法。
	 * 
	 * @param obj
	 *            对象。
	 * @return 返回对象的属性信息。
	 */
	public static Map<String, BeanAttribute> getBeanAttributes(Object obj) throws BeanException {
		return getBeanAttributes(obj.getClass());
	}

	/**
	 * 获取JavaBean的指定名称的属性值，属性名格式为:Test.Name，其中Test为一级属性名，Name为二级属性名。
	 * 
	 * @param arg
	 *            被获取属性值的JavaBean。
	 * @param name
	 *            属性名称。
	 * @return 返回属性值。
	 * @throws BeanException
	 *             获取错误时抛出异常。
	 */
	public static Object getProperty(Object arg, String name) throws BeanException {
		Object obj = arg;
		int offset = 0;
		int index = name.indexOf(".", offset);
		String str = null;
		while (index >= 0) {
			str = name.substring(offset, index);
			obj = getProperty1(obj, str);
			offset = index + 1;
			index = name.indexOf(".", offset);
		}
		str = name.substring(offset);
		obj = getProperty1(obj, str);
		return obj;
	}

	/**
	 * 获取JavaBean的指定名称的属性值。str为不分级的属性名，如Name。
	 * 
	 * @param obj
	 *            被获取属性值的JavaBean。
	 * @param str
	 *            属性名称。
	 * @return 返回属性值。
	 * @throws BeanException
	 *             获取错误时抛出异常。
	 */
	private static Object getProperty1(Object obj, String str) throws BeanException {
		BeanAttribute ab = getBeanAttributes(obj).get(str);
		if (ab == null || ab.getGetMethod() == null) {
			throw new BeanException("No property " + obj.getClass() + "." + str);
		}
		try {
			return ab.getGetMethod().invoke(obj, new Object[] {});
		} catch (IllegalArgumentException e) {
			throw new BeanException(e);
		} catch (IllegalAccessException e) {
			throw new BeanException(e);
		} catch (InvocationTargetException e) {
			throw new BeanException(e);
		}
	}

	/**
	 * 获取JavaBean的指定名称的属性值，str为不分级的属性名，如Name。如果属性值为Null则创建一个属性值返回。
	 * 
	 * @param obj
	 *            被获取属性值的JavaBean。
	 * @param str
	 *            属性名称。
	 * @return 返回属性值。
	 * @throws BeanException
	 *             获取错误时抛出异常。
	 */
	private static Object getProperty2(Object obj, String str) throws BeanException {
		BeanAttribute ab = getBeanAttributes(obj).get(str);
		if (ab == null || ab.getGetMethod() == null) {
			throw new BeanException("No property " + obj.getClass() + "." + str);
		}
		try {
			Object ret = ab.getGetMethod().invoke(obj, new Object[] {});
			if (ret == null) {
				if (ab.getAttributeClazz() == null || ab.getSetMethod() == null) {
					throw new BeanException("No property " + obj.getClass() + "." + str);
				}
				ret = ab.getAttributeClazz().newInstance();
				ab.getSetMethod().invoke(obj, new Object[] { ret });
			}
			return ret;
		} catch (IllegalArgumentException e) {
			throw new BeanException(e);
		} catch (IllegalAccessException e) {
			throw new BeanException(e);
		} catch (InvocationTargetException e) {
			throw new BeanException(e);
		} catch (InstantiationException e) {
			throw new BeanException(e);
		}
	}

	/**
	 * 获取clazz的指定名称的属性的类型，name为属性名称，如：Test.Name，其中Test为一级属性名，Name为二级属性名。
	 * 
	 * @param clazz
	 *            被获取的clazz。
	 * @param name
	 *            属性名称。
	 * @return 返回属性的类型。
	 * @throws BeanException
	 *             获取时错误抛出异常。
	 */
	public static Class<?> getType(Class<?> clazz, String name) throws BeanException {
		Class<?> cl = clazz;
		int offset = 0;
		int index = name.indexOf(".", offset);
		String str = null;
		while (index >= 0) {
			str = name.substring(offset, index);
			cl = getType1(cl, str);
			offset = index + 1;
			index = name.indexOf(".", offset);
		}
		str = name.substring(offset);
		return getType1(cl, str);
	}

	/**
	 * 获取clazz的指定名称的属性的类型，str为不分级的属性名，如Name。
	 * 
	 * @param clazz
	 *            被获取的clazz。
	 * @param str
	 *            属性名称。
	 * @return 返回属性的类型。
	 * @throws BeanException
	 *             获取时错误抛出异常。
	 */
	private static Class<?> getType1(Class<?> clazz, String str) throws BeanException {
		BeanAttribute ab = getBeanAttributes(clazz).get(str);
		if (ab == null || ab.getAttributeClazz() == null) {
			throw new BeanException("No property " + clazz + "." + str);
		}
		return ab.getAttributeClazz();
	}

	/**
	 * 设置JavaBean的指定名称的属性的值。name为属性名称，如：Test.Name，其中Test为一级属性名，Name为二级属性名。
	 * 
	 * @param arg
	 *            被设置的JavaBean。
	 * @param name
	 *            属性名称。
	 * @param value
	 *            属性值。
	 * @throws BeanException
	 *             设置时错误抛出异常。
	 */
	public static void setProperty(Object arg, String name, Object value) throws BeanException {
		Object obj = arg;
		int offset = 0;
		int index = name.indexOf(".", offset);
		String str = null;
		while (index >= 0) {
			str = name.substring(offset, index);
			obj = getProperty2(obj, str);
			offset = index + 1;
			index = name.indexOf(".", offset);
		}
		str = name.substring(offset);
		setProperty1(obj, str, value);
	}

	/**
	 * 设置JavaBean的指定名称的属性的值。name为属性名称，如：Name。
	 * 
	 * @param obj
	 *            被设置的JavaBean。
	 * @param str
	 *            属性名称。
	 * @param value
	 *            属性值。
	 * @throws BeanException
	 *             设置时错误抛出异常。
	 */
	private static void setProperty1(Object obj, String str, Object value) throws BeanException {
		BeanAttribute ab = getBeanAttributes(obj).get(str);
		if (ab == null || ab.getSetMethod() == null) {
			throw new BeanException("No property " + obj.getClass() + "." + str);
		}
		try {
			ab.getSetMethod().invoke(obj, new Object[] { value });
		} catch (IllegalArgumentException e) {
			throw new BeanException(e);
		} catch (IllegalAccessException e) {
			throw new BeanException(e);
		} catch (InvocationTargetException e) {
			throw new BeanException(e);
		}
	}

}
