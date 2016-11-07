package com.artion.datamodel;

import com.artion.datamodel.Student.Builder;

public class StudentMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student.Builder builder = new Builder().setName("呵呵")
				.setAge(22)
				.setNote("这是一个builder测试");
		Student student = builder.build();
		System.out.println(student.toString());
	}

}
