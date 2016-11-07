package com.artion.abserver;

import java.util.Observable;
import java.util.Observer;

public class NumObserver implements Observer {

	private NumChangeListener numChangeListener;

	public NumObserver(NumChangeListener numChangeListener) {
		this.numChangeListener = numChangeListener;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		NumObservable numObservable = (NumObservable) arg0;
		System.out.println("数据变更 " + numObservable.toString());

		if (numChangeListener != null) {
			numChangeListener.onChanged(numObservable.getNum());
		}
	}

	public interface NumChangeListener {
		public void onChanged(int num);
	}

}
