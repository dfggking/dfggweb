package com.javatest;
/**
 * 针对 值传递（pass by value）和引用传递（pass by reference） 理解
 * <p></p>
 * <pre></pre>
 * @author jinyf   
 * @date 2017年3月29日 上午11:29:01 
 * @since
 */
public class TestString {

	/** 
	 * Java四类八种数据类型
	 * *基本数据类型：
	 * 数值型
	 * byte
	 * short
	 * int
	 * long
	 * 浮点型
	 * float
	 * double
	 * 字符型
	 * char
	 * 布尔型
	 * boolean
	 * ----------------
	 * 引用数据类型：
	 * class
	 * interface
	 * 数组
	 **/
	public static void main(String[] args) {

		int i = 20; // 基本数据类型
		String str = "hello"; // 引用数据类型
		/**
		 * 基本数据类型，值就保存在变量中。
		 * 引用数据类型，变量中保存的实际对象的地址。这样的变量称为“引用”，引用指向实际对象，实际对象保存内容。
		 * 
		 * 基本数据类型，赋值运算符直接改变变量的值，原来的值被覆盖。
		 * 引用数据类型，赋值运算符改变引用中所保存的地址，原来的地址被覆盖掉。但是原来的对象不会被改变（我在读GC时，了解，没有被引用所指向的对象是垃圾了会被GC发现并回收）
		 * 
		 */
		str = "world";
		
//		method1(i);
//		System.out.println(i);
		
		
		StringBuilder sb = new StringBuilder("iphone");
//		method2(sb);
//		System.out.println(sb);
		
		method3(sb);
		System.out.println(sb);
	}
	
	/**
	 * 参数传递基本上就是赋值操作
	 */
	static void method1(int value){
		value = 100;
		System.out.println(value);
	}
	
	static void method2(StringBuilder builder){
		builder.append("4");
		System.out.println(builder);
	}
	
	static void method3(StringBuilder builder){
		builder = new StringBuilder("ipad");
		System.out.println(builder);
	}
}
