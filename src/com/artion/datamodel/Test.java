package com.artion.datamodel;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test() {
		Status status = new Status();
		
		Status other = new Status();
		other.setName("hello");
		other.setCount(100);
		
		status.setName("Artion");
		status.setCount(10);
		status.setOther(other);
		
		System.out.println("½á¹û£º" + status.toString());
		fail("Not yet implemented");
	}

}
