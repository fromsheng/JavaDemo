package com.artion.abserver;

import java.util.Observable;
import java.util.Observer;

public class EvenObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (arg.equals(NumObservable.EVEN)) {
			System.out.println("Å¼Êý " + o.toString());
		}
	}

}
