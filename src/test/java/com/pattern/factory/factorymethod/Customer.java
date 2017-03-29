package com.pattern.factory.factorymethod;

import com.pattern.factory.BMW320;
import com.pattern.factory.BMW520;

public class Customer {

	public static void main(String[] args) {
		FactoryBMW320 factoryBMW320 = new FactoryBMW320();
		BMW320 bmw320 = factoryBMW320.createBMW();
		
		FactoryBMW520 factoryBMW520 = new FactoryBMW520();
		BMW520 bmw520 = factoryBMW520.createBMW();
		
	}
}
