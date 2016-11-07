package com.artion.str;

import java.util.Calendar;

public class CalendarMain {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(Calendar.HOUR_OF_DAY, 3);
		calendar.set(Calendar.MINUTE, 20);
		getCalendarStartTime(calendar);
		getStartTime(calendar);
		
		calendar.set(Calendar.DAY_OF_MONTH, 27);
		calendar.set(Calendar.HOUR_OF_DAY, 13);
		calendar.set(Calendar.MINUTE, 33);
//		getCalendarStartTime(calendar);
		getStartTime(calendar);
		
		calendar.set(Calendar.HOUR_OF_DAY, 20);
		calendar.set(Calendar.MINUTE, 33);
//		getCalendarStartTime(calendar);
		getStartTime(calendar);
		
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 22);
//		getCalendarStartTime(calendar);
		getStartTime(calendar);
	}
	
	public static long getCalendarStartTime(Calendar mCalendar) {
		int month = mCalendar.get(Calendar.MONTH) + 1;
		int day = mCalendar.get(Calendar.DAY_OF_MONTH);
        int hours = mCalendar.get(Calendar.HOUR_OF_DAY);
        int minutes = mCalendar.get(Calendar.MINUTE);
        System.out.println("当前时间===" + month + "-" + day + " " + hours + ":" + minutes);
        if(minutes >= 30) {
            mCalendar.add(Calendar.HOUR_OF_DAY, 4);
            mCalendar.set(Calendar.MINUTE, 0);
        } else {
            mCalendar.add(Calendar.HOUR_OF_DAY, 3);
            mCalendar.set(Calendar.MINUTE, 30);
        }
        month = mCalendar.get(Calendar.MONTH) + 1;
        day = mCalendar.get(Calendar.DAY_OF_MONTH);
        hours = mCalendar.get(Calendar.HOUR_OF_DAY);
        minutes = mCalendar.get(Calendar.MINUTE);
        System.out.println("需要时间===" + month + "-" + day + " " + hours + ":" + minutes);
        return mCalendar.getTimeInMillis();
    }
	
	public static long getStartTime(Calendar mCalendar) {
		System.out.println("===getStartTime===");
		int month = mCalendar.get(Calendar.MONTH) + 1;
		int day = mCalendar.get(Calendar.DAY_OF_MONTH);
        int hours = mCalendar.get(Calendar.HOUR_OF_DAY);
        int minutes = mCalendar.get(Calendar.MINUTE);
        System.out.println("当前时间===" + month + "-" + day + " " + hours + ":" + minutes);
        
        mCalendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        mCalendar.add(Calendar.DAY_OF_MONTH, 7);
        mCalendar.set(Calendar.HOUR_OF_DAY, 8);
        mCalendar.set(Calendar.MINUTE, 0);
        month = mCalendar.get(Calendar.MONTH) + 1;
        day = mCalendar.get(Calendar.DAY_OF_MONTH);
        hours = mCalendar.get(Calendar.HOUR_OF_DAY);
        minutes = mCalendar.get(Calendar.MINUTE);
        System.out.println("需要时间===" + month + "-" + day + " " + hours + ":" + minutes);
        return mCalendar.getTimeInMillis();
	}
}
