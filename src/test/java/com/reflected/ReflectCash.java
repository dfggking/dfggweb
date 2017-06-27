package com.reflected;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectCash {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Proxy target = new Proxy();
		
		Method method = Proxy.class.getDeclaredMethod("run");
		method.invoke(target);
		
		
		
	}
	
}

class Proxy {
	public void run() {
		System.out.println("run");
	}
}