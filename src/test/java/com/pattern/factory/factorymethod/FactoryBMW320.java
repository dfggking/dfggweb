package com.pattern.factory.factorymethod;

import com.pattern.factory.BMW;
import com.pattern.factory.BMW320;

public class FactoryBMW320 implements FactoryBMW {

	@Override
	public BMW320 createBMW() {
		// TODO Auto-generated method stub
		return new BMW320();
	}

}
