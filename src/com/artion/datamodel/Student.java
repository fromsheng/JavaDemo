package com.artion.datamodel;

public class Student extends StudentProperty {
	
	public Student(Builder builder) {
		this.name = builder.name;
		this.age = builder.age;
		this.note = builder.note;
	}
	
	public static class Builder extends StudentProperty {
		public Builder() {
			super();
		}
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder setAge(int age) {
			this.age = age;
			return this;
		}
		
		public Builder setNote(String note) {
			this.note = note;
			return this;
		}
		
		public Student build() {
			return new Student(this);
		}
	}
}
