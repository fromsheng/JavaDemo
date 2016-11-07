package com.artion.asynchttp;

import com.loopj.android.http.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AsyncHttpClient client = new AsyncHttpClient();
		
		client.get("http://www.google.com", new AsyncHttpResponseHandler(){

			@Override
			public void onSuccess(String response) {
				// TODO Auto-generated method stub
				super.onSuccess(response);
				
				System.out.println(response);
			}
			
		});
		
		System.out.println("System.out.println(response);");
	}

}
