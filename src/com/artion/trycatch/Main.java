package com.artion.trycatch;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		fun(0);

		fun(1);

		fun(2);
		
//		fun2(0, 100000000);
//
//		fun2(1, 100000000);
//
//		fun2(2, 100000000);
	}

	public static void fun(int type) {
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			switch (type) {
			case 0:

				break;
			case 1:
				try {
				} catch (Exception e) {
				}
				break;
			case 2:
				try {
					throw new Exception();
				} catch (Exception e) {
				}
				break;
			}
		}
		System.out.println("ºÄÊ±£º" + (System.currentTimeMillis() - t1));
	}

	public static void fun2(int type, int size) {
		long t1 = System.currentTimeMillis();
		int count = 0;
		switch (type) {
		case 0:
			for (int i = 0; i < size; i++) {
				count ++;
			}
			break;
		case 1:
			try {
				for (int i = 0; i < size; i++) {
					count ++;
				}
			} catch (Exception e) {

			} finally {

			}
			break;
		case 2:
			try {
				for (int i = 0; i < size; i++) {
					count ++;
				}
			} finally {

			}
		}
		System.out.println("ºÄÊ±£º" + (System.currentTimeMillis() - t1));
	}

}
