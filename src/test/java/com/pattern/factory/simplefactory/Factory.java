package com.pattern.factory.simplefactory;

import com.pattern.factory.BMW;
import com.pattern.factory.BMW320;
import com.pattern.factory.BMW520;

public class Factory {

	public BMW createBMW(int type){
		
		switch (type) {
		case 320:
			return new BMW320();
		case 520:
			return new BMW520();
		default:
			break;
		}
		return null;
	}
}
