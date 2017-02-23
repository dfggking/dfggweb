package com.test.java;

public class StringClass {
	
	public static void main(String[] args) {

		String s1 = "hello";
		String s2 = "world";
		String str = "helloworld";
		System.out.println(str == s1+s2); // false
		System.out.println(str == "helloworld"); // true
		System.out.println(str == "hello"+"world"); // true
	}
	
	
}
