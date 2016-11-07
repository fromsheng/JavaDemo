package com.artion.abserver;

import java.util.Observable;

public class NumObservable extends Observable {
	
	public final static Integer ODD = 1;
	public final static Integer EVEN = 2;
	
	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
		
		Integer flag = EVEN;
		
		if((num & 0x0001) == 1){
			flag = ODD;
		}
		
		setChanged();
		notifyObservers(flag);
	}

	@Override
	public String toString() {
		return "当前数据是 " + num;
	}
	
	
}
