package com.artion.abserver;

import java.util.Observable;
import java.util.Observer;

public class OddObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (arg.equals(NumObservable.ODD)) {
			System.out.println("ÆæÊý " + o.toString());
		}
	}

}
