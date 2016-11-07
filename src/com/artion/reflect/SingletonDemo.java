package com.artion.reflect;

public class SingletonDemo {
	public static void main(String[] args) {
		Singleton obj1 = SingletonFactory.getInstance(Singleton.class, null);  
		System.out.println(obj1.toString());
        Singleton obj2 = SingletonFactory.getInstance(Singleton.class, "hello"); 
        System.out.println(obj1.toString());
        System.out.println(obj2.toString());
        System.out.println(obj1 == obj2);  
	}
}
