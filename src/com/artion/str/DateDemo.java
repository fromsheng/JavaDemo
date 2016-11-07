package com.artion.str;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class DateDemo {

	public static void main(String[] args) {

		String date1 = "2014-10-24 10:49:32";
		String date2 = "2013-10-22 10:49:32";
		
		System.out.println(date1);
		System.out.println(getFormatDayStr(date1));
		System.out.println(date2);
		System.out.println(getFormatDayStr(date2));
		System.out.println("isSameDay == " + isSameDay(date1, date2));
		
		
		DateFormat df = new SimpleDateFormat("MM月dd日");
		System.out.println(df.format(new Date()));
		
		System.out.println(getFormatChDayStr(date2));
		
		System.out.println(getFormatMdHmStr(date1));
		
		System.out.println(getFormatXXX(date1));
		
		System.out.println("***********************************");
		
		 // 当前系统默认时区的时间：
		         Calendar calendar = new GregorianCalendar();
		         System.out.println("long == " + calendar.getTime().getHours());
		         System.out.print("时区：" + calendar.getTimeZone().getID() + "  ");
		         System.out.println("时间：" + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE));
		         
		         System.out.print(calendar.get(Calendar.YEAR) + " ");
		         System.out.print(calendar.get(Calendar.MONTH) + " ");
		         System.out.print(calendar.get(Calendar.DAY_OF_MONTH) + " ");
		         System.out.print(calendar.get(Calendar.HOUR_OF_DAY) + " ");
		         System.out.print(calendar.get(Calendar.MINUTE) + " ");
		         System.out.println(calendar.get(Calendar.SECOND) + " ");
		         
		         // 美国洛杉矶时区
		         TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
		        // 时区转换
		         calendar.setTimeZone(tz);
		         System.out.println("long == " + calendar.getTime().getHours());
		         System.out.print("时区：" + calendar.getTimeZone().getID() + "  ");
		         System.out.println("时间：" + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE));
		         
		         System.out.print(calendar.get(Calendar.YEAR) + " ");
		         System.out.print(calendar.get(Calendar.MONTH) + " ");
		         System.out.print(calendar.get(Calendar.DAY_OF_MONTH) + " ");
		         System.out.print(calendar.get(Calendar.HOUR_OF_DAY) + " ");
		         System.out.print(calendar.get(Calendar.MINUTE) + " ");
		         System.out.println(calendar.get(Calendar.SECOND) + " ");
		         
		         
		         // 1、取得本地时间：
		                  java.util.Calendar cal = java.util.Calendar.getInstance();
		                  
		                  // 2、取得时间偏移量：
		                  int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
		                  System.out.println("zoneOffset = " + zoneOffset);
		                // 3、取得夏令时差：
		                  int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
		                  System.out.println("dstOffset = " + dstOffset);
		                  // 4、从本地时间里扣除这些差量，即可以取得UTC时间：
		                  cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
		                  
		                  // 之后调用cal.get(int x)或cal.getTimeInMillis()方法所取得的时间即是UTC标准时间。
		                  System.out.println("UTC:" + new Date(cal.getTimeInMillis()));
		                  
		                 Calendar calendar1 = Calendar.getInstance();
		                  TimeZone tztz = TimeZone.getTimeZone("GMT");
		                  calendar1.setTimeZone(tztz);
		                  System.out.println(calendar.getTime());
		                  System.out.println(calendar.getTimeInMillis());
	}
	
	public static String getChTimeZoneData(Calendar cal) {
		 // 当前系统默认时区的时间：
		 Calendar calendar = new GregorianCalendar();
		 calendar.setTime(cal.getTime());
		TimeZone tz = TimeZone.getTimeZone("Asia/Shanghai");
		
		// 时区转换
        calendar.setTimeZone(tz);

        cal.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        cal.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
        cal.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        cal.set(Calendar.SECOND, calendar.get(Calendar.SECOND));
        
		
		return cal.getTime().toString();
	}

	
	public static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static String DATE_FORMAT_DAY = "yyyy-MM-dd";
	public static String DATE_FORMAT_MdHm = "MM-dd HH:mm";
	public static String getFormatDayStr(String date) {
		if(date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DAY, Locale.US);
		try {
			Date d = sdf.parse(date);
			return sdf.format(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}
	
	public static String getFormatMdHmStr(String date) {
		if(date == null) {
			return null;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.US);
		try {
			Date d = sdf.parse(date);
			sdf = new SimpleDateFormat(DATE_FORMAT_MdHm);
			return sdf.format(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	public static boolean isSameDay(String date1, String date2) {
		if (date1 == null || date2 == null) {
			return false;
		}
		String f1 = getFormatDayStr(date1);
		String f2 = getFormatDayStr(date2);
		if (f1 == null || f2 == null) {
			return false;
		}
		return f1.equals(f2);
	}
	public static String getFormatXXX(String d) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.US);
		Date dt;
		try {
			dt = sdf.parse(d);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dt);
			final long DAY_MILLIS = 24*60*60*1000;
			Calendar curC = Calendar.getInstance();
			
			sdf = new SimpleDateFormat(DATE_FORMAT_DAY, Locale.US);
			
			String curDate = sdf.format(curC.getTime());
			String date = sdf.format(calendar.getTime());
			if(curDate.equals(date)) {
				return "今天";
			}
			
			long l = curC.getTimeInMillis();
			long l_b = l - DAY_MILLIS;
			curC.setTimeInMillis(l_b);
			curDate = sdf.format(curC.getTime());
			if(curDate.equals(date)) {
				return "昨天";
			}
			
			long l_b2 = l_b - DAY_MILLIS;
			curC.setTimeInMillis(l_b2);
			curDate = sdf.format(curC.getTime());
			if(curDate.equals(date)) {
				return "前天";
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return getFormatChDayStr(d);
	}
	public static String getFormatChDayStr(String date) {
		if(date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.US);
		try {
			Date d = sdf.parse(date);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH) + 1;
			int day = calendar.get(Calendar.DATE);
			
			Calendar curC = Calendar.getInstance();
			int curYear = curC.get(Calendar.YEAR);
			int curMonth = curC.get(Calendar.MONTH) + 1;
			int curDay = curC.get(Calendar.DATE);
			
			if(curYear == year) {
				return month + "月" + day + "日";
			} else {
				return year + "年" + month + "月" + day + "日";
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}
}
