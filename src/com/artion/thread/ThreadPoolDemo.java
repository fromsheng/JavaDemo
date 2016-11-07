package com.artion.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			final int index = i;
//			if(!executor.isShutdown()) {
			try{
				executor.execute(new Runnable() {

					@Override
					public void run() {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("当前是i == " + index);
					}
				});
			} catch(Exception e) {
				
			}
//			}
			
			if(i == 5) {
				executor.shutdown();
			}
		}
	}

}
