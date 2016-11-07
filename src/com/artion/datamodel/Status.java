package com.artion.datamodel;

import java.io.Serializable;

import com.artion.frame.MyBuilder;

public class Status implements Serializable {
	
	private String name;
	private int count;
	
	private Status other = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Status getOther() {
		return other;
	}

	public void setOther(Status other) {
		this.other = other;
	}

	@Override
	public String toString() {
		return "name = " + name 
				+ ", count = " + count
				+ ", other = " + (other != null ? other.toString() : null);
	}
	
	public static class Builder extends MyBuilder<Status> {
		
		public Builder(String name) {
			super();
			
		}

		@Override
		public Status build() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

	
}
