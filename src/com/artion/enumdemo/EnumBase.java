package com.artion.enumdemo;

public enum EnumBase {
	E1("EE1"), E2("EE2"), E3("EE3");
	
	private String name;
	
	EnumBase(String s) {
		this.name = s;
	}
	
	public String getName() {
		return this.name;
	}
}
