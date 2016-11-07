package com.artion.datamodel;

public abstract class StudentProperty {
	protected String name;
	protected int age;
	protected String note;
	
	@Override
	public String toString() {
		return "name=" + name + "--age=" + age + "--note=" + note;
	}
	
}
