package com.pattern.factory.simplefactory;

import com.pattern.factory.BMW;

public class Customer {

	public static void main(String[] args) {
		Factory factory = new Factory();
		
		BMW bmw320 = factory.createBMW(320);
		BMW bmw520 = factory.createBMW(520);
		
	}
}
