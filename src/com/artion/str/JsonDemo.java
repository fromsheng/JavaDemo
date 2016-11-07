package com.artion.str;

import net.sf.json.JSONObject;



public class JsonDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "{\"data\":\"123\"}";
		System.out.println(data);
		
		
		try {
			JSONObject json = JSONObject.fromObject(data);
			
			System.out.println(json.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
