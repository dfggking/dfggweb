package com.test.java;

import java.util.ArrayList;
import java.util.Arrays;

public class testListAndArray {

	public static void main(String[] args) {

		// List to array
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		String str[] = new String[list.size()];
//		for (int i = 0; i < list.size(); i++) {
//			str[i] = list.get(i);
//		}
//		for (int i = 0; i < str.length; i++) {
//			System.out.println(str[i]);
//		}
		String[] strings = new String[list.size()];
		String[] str2 = list.toArray(strings);
		
		// array to List
		String[] s = {"a", "b", "c"};
		Arrays.asList(s);
		
		// 生成数组三种方法
		int[] i = {1, 2};
		
		int[] i2 = new int[7];
		
		int[] i3 = new int[]{1,2,3,4,3};
	}

}
