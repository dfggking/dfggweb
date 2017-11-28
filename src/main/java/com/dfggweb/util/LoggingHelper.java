package com.dfggweb.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

import com.dfggweb.util.bean.BeanAttribute;
import com.dfggweb.util.bean.BeanAttributeHelper;
import com.dfggweb.util.bean.BeanException;


/**
 * 日志的帮助类。
 * 
 * @author LiuBo
 * 
 */
public abstract class LoggingHelper {

	/**
	 * 将数组中的对象转成字符串，每个元素中间换行。
	 * 
	 * @param objects
	 *            转换的数组
	 * @return 返回转换后的字符串。
	 * @throws BeanException
	 *             转换时出现错误。
	 */
	public static String beanDetails(Object... objects) throws BeanException {
		if (objects == null) {
			return "null";
		}
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		for (Object obj : objects) {
			if (flag) {
				sb.append(StringHelper.NEWLINE);
			}
			if (obj == null) {
				sb.append("null");
			} else {
				sb.append(obj.getClass());
				Map<String, BeanAttribute> attributes = BeanAttributeHelper.getBeanAttributes(obj);
				Set<String> set = attributes.keySet();
				for (String string : set) {
					BeanAttribute attribute = attributes.get(string);
					if (attribute != null && attribute.getGetMethod() != null) {
						try {
							sb.append(" [");
							sb.append(attribute.getAttributeName());
							sb.append(":");
							sb.append(attribute.getGetMethod().invoke(obj, new Object[] {}));
							sb.append("]");
						} catch (IllegalArgumentException e) {
							throw new BeanException(e);
						} catch (IllegalAccessException e) {
							throw new BeanException(e);
						} catch (InvocationTargetException e) {
							throw new BeanException(e);
						}
					}
				}
			}
			flag = true;
		}
		return sb.toString();
	}

	/**
	 * 将单个对象转成字符串。
	 * 
	 * @param obj
	 *            转换的对象
	 * @return 返回转换后的字符串。
	 * @throws BeanException
	 *             转换时出现错误。
	 */
	public static String beanDetails(Object obj) throws BeanException {
		if (obj == null) {
			return "null";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(obj.getClass());
		Map<String, BeanAttribute> attributes = BeanAttributeHelper.getBeanAttributes(obj);
		Set<String> set = attributes.keySet();
		for (String string : set) {
			BeanAttribute attribute = attributes.get(string);
			if (attribute != null && attribute.getGetMethod() != null) {
				try {
					sb.append(" [");
					sb.append(attribute.getAttributeName());
					sb.append(":");
					sb.append(attribute.getGetMethod().invoke(obj, new Object[] {}));
					sb.append("]");
				} catch (IllegalArgumentException e) {
					throw new BeanException(e);
				} catch (IllegalAccessException e) {
					throw new BeanException(e);
				} catch (InvocationTargetException e) {
					throw new BeanException(e);
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 将数组转成字符串。
	 * 
	 * @param objects
	 *            转换的数组
	 * @return 返回数组转换后的字符串。
	 */
	public static String arrayDetails(Object... objects) {
		if (objects == null) {
			return "null";
		}
		StringBuilder sb = new StringBuilder();
		for (Object object : objects) {
			sb.append(" [");
			sb.append(object);
			sb.append("]");
		}
		return sb.toString();
	}

}
