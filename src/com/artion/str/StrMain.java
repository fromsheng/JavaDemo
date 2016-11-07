package com.artion.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StrMain {
	
	public static String trimRight(String str) {
//		 return str.replace("(^\\s*)|(\\s*$)", "8");
		return str.replaceAll("\\s\\s+$", ".");
	}
	
	public static void checkEmpty(String str) {
		String pattern = " ";
		boolean ifMatch = str.matches(pattern);
		System.out.println("" + ifMatch);
	}

	public static  boolean isMobileNO(String mobiles){  
		  
		if(mobiles == null) {
			return false;
		}
		Pattern p = Pattern
				.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9])|(14[0-9])|(17[0-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();  
		}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> ids = new ArrayList<String>();
		for (int i = 0; i < 22; i++) {
			ids.add("" + i);
		}
		List<String> newIds;
		for (int i = 0; i < ids.size(); i+=5) {
			int start = i;
			int end = start + 5;
			if(end > ids.size()) {
				end = ids.size();
			}
			newIds = ids.subList(start, end);
			for (int j = 0; j < newIds.size(); j++) {
				System.out.print(newIds.get(j) + " ");
			}
			System.out.println();
		}
		
		StringBuilder sb1 = new StringBuilder();
		sb1.append("回复 @");
		sb1.append("蔡锦升");
		sb1.append("：");
		sb1.append("这是一个测试");
		sb1.append("//\n");
		sb1.append("fdasfas");
		System.out.println(sb1.toString());
		
		String arr1 = "\\";
		System.out.println("arr1 == " + arr1);
		String arr2 = "\\\\";
		System.out.println("arr2 == " + arr2);
//		System.out.println("arr1.replaceAll == " + arr1.replaceAll("\\", "\\\\"));
		System.out.println("arr1.replaceAll2 == " + arr1.replaceAll("\\\\", "\\\\\\\\"));
		System.out.println("arr1.Pattern.quote == " + Pattern.quote(arr1));
		
		String nstr = "    ";
		while(nstr.startsWith(" ")){
			nstr = nstr.substring(1, nstr.length()).trim();
	    }

		System.out.println(nstr);
			nstr = nstr.replaceAll(" ", "");
		System.out.println(nstr);
		
		
		int status = 0xe;
		System.out.println("status = " + (status));
		System.out.println(">>0 = " + (status & 1));
		System.out.println(">>1 = " + (status>>1 & 1));
		System.out.println(">>2 = " + (status>>2 & 1));
		System.out.println(">>3 = " + (status>>3 & 1));
		
		
		String myString = "   ";
		checkEmpty(myString);
		System.out.println(trimRight(myString));
		
//		String[] sss = new String[] {
//				"aaaa",
//				"bbbb",
//				"cccc"
//		};
//		System.out.println(sss.toString());
		List<String> urls = new ArrayList<String>();
		urls.add("a000");
		urls.add("b111");
		urls.add("c222");
		System.out.println(urls);
		System.out.println(urls.toString());
		
		List<String> tmpList = new ArrayList<String>();
		System.out.println(urls.toString().replace("[", "").replace("]", ""));
		tmpList = Arrays.asList(urls.toString().replace("[", "").replace("]", ""));
		System.out.println(tmpList);
		
		String className = "com.artion.str.UrlMatch";
		try {
			System.out.println("className == " + Class.forName(className));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<String> list = new ArrayList<String>();
		List<String> tmp = new ArrayList<String>();
		list.addAll(tmp);
		
		System.out.println("size == " + list.size());
		
		System.out.println(isMobileNO("14310575685"));
		
		VerifyTools.isInMyTime();
		
		String url = "rest||192.165465";
		
		String[] strs = url.split("\\|\\|");
		for(String s : strs) {
			System.out.println(s);
		}
		
		System.out.println("13510575685 == " + VerifyTools.verifyNumber("13510575685"));
		
		
		String [] contacts = {
				"1001",
				"1002",
				"1003"
		};
		
		StringBuffer sb = new StringBuffer();
		for(String s : contacts) {
			sb.append(s);
			sb.append(",");
		}
		System.out.println("before == " + sb.toString());
		if(sb.length() > 0) {
			sb.substring(0, sb.length() - 1);
		}
		
		System.out.println("after  == " + sb.substring(0, sb.length() - 1));
		
		
		
		/**********************************/
		final String PRE = ",,,,,,";
		String topic1 = "费用报销" + PRE;
		String topic2 = "费用报销" + PRE + "123";
		System.out.println("topic1 == " + topic1);
		if(topic1.indexOf(PRE) > 0) {
			System.out.println("topic1有");
		} else {
			System.out.println("topic1无");
		}
		
		System.out.println("topic2 == " + topic2);
		if(topic2.indexOf(PRE) > 0) {
			System.out.println("topic2有");
		} else {
			System.out.println("topic21无");
		}
		
		
		
		System.out.println("100 " + VerifyTools.getNaturalNumberString("100"));
		System.out.println("-100 " + VerifyTools.getNaturalNumberString("-100"));
		System.out.println("1a0 " + VerifyTools.getNaturalNumberString("1a0"));
		
		
		String upperStr = "AAAA";
		String lowStr = "aaaa";
		System.out.println("equalsIgnoreCase == " +upperStr.equalsIgnoreCase(lowStr));
		System.out.println("equals == " +upperStr.equals(lowStr));
		
		
		System.out.println(upperStr.toLowerCase().endsWith(lowStr));
		
		
		
		
		
		String content = "\n2004-14-112abceefgfdasfs";
		System.out.println(content);
		System.out.println("-----------------------");
		String title = "";
		if(content.indexOf("\n") > 0) {
			int enterLen = "\n".length();
			title = content.substring(0, content.indexOf("\n"));
			if(content.indexOf("\n") + enterLen < content.length()) {
				content = content.substring(content.indexOf("\n") + enterLen, content.length());
			}
		} else {
			title = content;
		}
		System.out.println(content);
		
		
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		System.out.println(VerifyTools.verifyNumber("0100"));;
		System.out.println(VerifyTools.verifyNumber("-100"));;
		
		
		System.out.println(content.contains("cee"));
	}

}
