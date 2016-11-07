package com.artion.str;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long t0 = System.currentTimeMillis();
		List<String> list = new ArrayList<String>();
//		for (int i = 0; i < 1000000; i++) {
//			list.add("str_" + i);
//		}
		
		long t1 = System.currentTimeMillis();
		System.out.println("init耗时ms：" + (t1-t0));
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//		long t2 = System.currentTimeMillis();
//		System.out.println("for耗时ms：" + (t2-t1));
		
		long t3 = System.currentTimeMillis();
		Iterator<String> iterator = list.iterator();
		long t4 = System.currentTimeMillis();
		System.out.println("iterator init耗时ms：" + (t4-t3));
		while (iterator.hasNext()) {
//			System.out.println(iterator.next());
			iterator.next();
		}
		long t5 = System.currentTimeMillis();
		System.out.println("iterator耗时ms：" + (t5-t4));
	}

}
