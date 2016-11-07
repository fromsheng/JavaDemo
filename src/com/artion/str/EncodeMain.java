package com.artion.str;

import java.io.UnsupportedEncodingException;

public class EncodeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String str = "恭喜发财,，大吉大利!123456789你";
		System.out.println(VerifyTools.getEllipsizeText(str, 8));
		System.out.println(VerifyTools.getSpliteStrs(str, 10, 2));
		String[] splites = str.split("");
		for (int i = 0; i < splites.length; i++) {
			if(splites[i].length()>0) {
				System.out.print(splites[i] + "-");
			}
		}
		System.out.println();
		System.out.println(str);
		System.out.println(str.length());
		
		System.out.println(VerifyTools.getByteLength(str));
		
		System.out.println("getCount=" + VerifyTools.getCount(str));
		
		System.out.println(str.substring(0, 6));
		
		int byelen = VerifyTools.getByteLength(str);
		
		try {
			byte[] byeStrs = str.getBytes("GBK");
			byte[] b1 = new byte[12];
			System.arraycopy(byeStrs, 0, b1, 0, 12);
			String s1 = new String(b1, "GBK");
			System.out.println(s1);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		if(byelen > 12) {
//			System.out.println(str.substring(0, 12));
//		} else {
//			System.out.println(str);
//		}
		
	}

}
