package com.artion.prscrn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EnterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("----" + args[0]);
		
		readTest();  
	    scannerTest();  
	}
	public static void readTest(){  
	      System.out.println("readTest,����������...");  
	        InputStreamReader is = new InputStreamReader(System.in);  
	        BufferedReader br = new BufferedReader(is);  
	        try {  
	            String name = br.readLine();  
	            System.out.println("readTest,�����"+name);  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	  }  
	  public static void scannerTest(){  
	      System.out.println("scannerTest,����������...");  
	      String name=new Scanner(System.in).nextLine();  
	      System.out.println("scannerTest,�����"+name);  
	  }  
}
