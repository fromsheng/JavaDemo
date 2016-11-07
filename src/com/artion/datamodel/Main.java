package com.artion.datamodel;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.artion.utils.Base64;
import com.artion.utils.FileSaveManager;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Status status = new Status();
		
		Status other = new Status();
		other.setName("hello");
		other.setCount(100);
		
		status.setName("Artion");
		status.setCount(10);
		status.setOther(other);
		
		System.out.println("���" + status.toString());
		
		
		
		List<Status> urls = new ArrayList<Status>();
		Status s = new Status();
		s.setName("hello");
		s.setCount(100);
		urls.add(s);
		s = new Status();
		s.setName("hello1");
		s.setCount(101);
		urls.add(s);
		s = new Status();
		s.setName("hello2");
		s.setCount(102);
		urls.add(s);
		System.out.println(urls.toString());
		byte[] tmpBytes = FileSaveManager.objectToByteArray(urls);
		System.out.println(tmpBytes.length);
		String byteStr;
		try {
			byteStr = Base64.encode(tmpBytes);
			System.out.println(byteStr);
			
			byte[] finalByte = Base64.decode(byteStr);
			System.out.println(finalByte.length);
			List<Status> finalObj = (List<Status>) FileSaveManager.byteArraytoObject(finalByte);
			System.out.println(finalObj.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Status> finalObj = (List<Status>) FileSaveManager.byteArraytoObject(tmpBytes);
		System.out.println(finalObj.toString());
		
	}

}
