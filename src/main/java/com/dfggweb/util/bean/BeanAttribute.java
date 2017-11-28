package com.dfggweb.util.bean;

import java.lang.reflect.Method;

/**
 * 装有JavaBean属性的相关信息，包括属性名、set方法、get方法、属性类型，一般用于反射。
 * 
 * @author LiuBo
 */
public class BeanAttribute {

	/** 属性名称 */
	protected String attributeName;

	/** set方法 */
	protected Method setMethod;

	/** get方法 */
	protected Method getMethod;

	/** 属性的类型 */
	protected Class<?> attributeClazz;

	/**
	 * 获取属性的名称。
	 * 
	 * @return 返回属性的名称。
	 */
	public String getAttributeName() {
		return attributeName;
	}

	/**
	 * 设置属性的名称。
	 * 
	 * @param attributeName
	 *            属性名称。
	 */
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	/**
	 * 获取Set方法。
	 * 
	 * @return 返回Set方法。
	 */
	public Method getSetMethod() {
		return setMethod;
	}

	/**
	 * 设置Set方法。
	 * 
	 * @param setMethod
	 *            Set方法。
	 */
	public void setSetMethod(Method setMethod) {
		this.setMethod = setMethod;
	}

	/**
	 * 获取Get方法。
	 * 
	 * @return 返回Get方法。
	 */
	public Method getGetMethod() {
		return getMethod;
	}

	/**
	 * 设置Get方法。
	 * 
	 * @param getMethod
	 *            Get方法。
	 */
	public void setGetMethod(Method getMethod) {
		this.getMethod = getMethod;
	}

	/**
	 * 获取属性的类型。
	 * 
	 * @return 返回属性的类型。
	 */
	public Class<?> getAttributeClazz() {
		return attributeClazz;
	}

	/**
	 * 设置属性的类型。
	 * 
	 * @param attributeClazz
	 *            属性的类型。
	 */
	public void setAttributeClazz(Class<?> attributeClazz) {
		this.attributeClazz = attributeClazz;
	}

}
