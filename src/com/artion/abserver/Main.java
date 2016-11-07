package com.artion.abserver;

import java.lang.reflect.Field;

import com.artion.abserver.NumObserver.NumChangeListener;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumObservable numObservable = new NumObservable();
		numObservable.addObserver(new NumObserver(new NumChangeListener() {

			@Override
			public void onChanged(int num) {
				// TODO Auto-generated method stub
				System.out.println("哈哈，终于给我等到你改变了哈，是 " + num);
			}
		}));

		// numObservable.addObserver(new EvenObserver());
		// numObservable.addObserver(new OddObserver());

		numObservable.setNum(1);

		numObservable.setNum(2);

		numObservable.setNum(3);

		Field[] fields1 = numObservable.getClass().getDeclaredFields();
		for (int i = 0; i < fields1.length; i++) {
			System.out.println("属性名有：" + fields1[i].getName());
//			System.out.println("属性类型是：" + fields1[i].getType().toString());
		}
	}

}
