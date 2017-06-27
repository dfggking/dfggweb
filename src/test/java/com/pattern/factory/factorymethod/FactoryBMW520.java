package com.pattern.factory.factorymethod;

import com.pattern.factory.BMW;
import com.pattern.factory.BMW520;

public class FactoryBMW520 implements FactoryBMW {

	@Override
	public BMW520 createBMW() {
		// TODO Auto-generated method stub
		return new BMW520();
	}

}
