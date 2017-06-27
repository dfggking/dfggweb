package com.util;

import java.util.HashSet;
import java.util.Set;

public class TestImpl implements TestInterface2 {

	
	
	public void Method() {
		System.out.println(TestInterface.STR_I);
	}

	
	public static void main(String[] args) {
		new TestImpl().Method();
		
		
		
		Set set = new HashSet();
		
		set.add(1);
		
		set.add(3);
		
		set.add(1);
		
		System.out.println(set.size());
		
		
		
		
		
		
	}
}
