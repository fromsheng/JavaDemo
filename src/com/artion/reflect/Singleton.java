package com.artion.reflect;

public class Singleton {
	private String text = "default";
	private Singleton() {
		
	}
	
	private Singleton(String s) {
		this.text = s;
	}
	
	@Override
	public String toString() {
		return "text = " + text;
	}
}
