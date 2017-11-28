package com.dfggweb.util.bean;

/**
 * 对JavaBean操作时发生的错误。
 * 
 * @author LiuBo
 */
public class BeanException extends Exception {

	private static final long serialVersionUID = 1311091160032947229L;

	/**
	 * 默认的的形式构造BeanException。
	 */
	public BeanException() {
		super();
	}

	/**
	 * 以指定的消息和原因构造BeanException。
	 * 
	 * @param message
	 *            消息。
	 * @param cause
	 *            原因。
	 */
	public BeanException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 以指定的消息构造BeanException。
	 * 
	 * @param message
	 *            消息。
	 */
	public BeanException(String message) {
		super(message);
	}

	/**
	 * 以指定的原因构造BeanException。
	 * 
	 * @param cause
	 *            原因。
	 */
	public BeanException(Throwable cause) {
		super(cause);
	}

}
