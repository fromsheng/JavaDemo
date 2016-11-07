package com.artion.enumdemo;

public class EnumMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "EE3";
		System.out.println("1 ==== " + EnumBase.values()[1].getName());
		System.out.println("---- " + EnumBase.values()[1].ordinal());
		System.out.println("----- " + EnumBase.valueOf(EnumBase.E1.getName()).getName());
	}

}
