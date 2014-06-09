package com.vng.csm.helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import java.sql.Timestamp;

public class DateHelper {

	public static String ymdToVNDate(String ymd) {
		return dateFormat(ymd, "yyyyMMdd", "dd/MM/yyyy");
	}

	public static String ymdToVNDate(int ymd) {
		String strYmd = String.valueOf(ymd);
		return ymdToVNDate(strYmd);
	}

	public static String dateToYmd(String date) {
		String patternIn= "yyyy-MM-dd HH:mm:ss";
		if(date.length()<=10){
			patternIn = "yyyy-MM-dd";
		}		
		return dateFormat(date, patternIn, "yyyyMMdd");
	}

	public static String vnDateToYmd(String vnDate) {
		String patternIn= "dd/MM/yyyy HH:mm:ss";
		if(vnDate.length()<=10){
			patternIn = "dd/MM/yyyy";
		}		
		return dateFormat(vnDate, patternIn, "yyyyMMdd");
	}

	public static String ymdToDate(String ymd) {
		return dateFormat(ymd, "yyyyMMdd", "yyyy-MM-dd");
	}	
	
	
	public static String ymdToDate(int ymd) {
		return ymdToDate(String.valueOf(ymd));
	}

	public static String timeToVNDate(String timeStamp, boolean hasTime) {
		Date date = new Date(Long.valueOf(timeStamp));
		Calendar cal = new GregorianCalendar();
		SimpleDateFormat sdf = null;
		if (hasTime) {
			sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		} else {
			sdf = new SimpleDateFormat("dd/MM/yyyy");
		}
		return sdf.format(date);

	}

	public static String timeToDate(String timeStamp, boolean hasTime) {
		Date date = new Date(Long.valueOf(timeStamp));
		Calendar cal = new GregorianCalendar();
		SimpleDateFormat sdf = null;
		if (hasTime) {
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		} else {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		}
		return sdf.format(date);
	}

	public static String getTimeStamp(){
		Date date= new Date();
		Timestamp ts = new Timestamp(date.getTime());	
		return String.valueOf(ts.getTime());
	}
	
	public static String getTimeStamp(Date d){
		Timestamp ts = new Timestamp(d.getTime());	
		return String.valueOf(ts.getTime());
	}
	
	public static String vnDateToDate(String vnDate, boolean hasTime) {
		String patternIn= "dd/MM/yyyy HH:mm:ss";
		if(vnDate.length()<=10){
			patternIn = "dd/MM/yyyy";
		}
		if (hasTime) {
			return dateFormat(vnDate, patternIn, "yyyy-MM-dd HH:mm:ss");
		}
		return dateFormat(vnDate, patternIn, "yyyy-MM-dd");
	}
	
	public static String dateToVNDate(String date, boolean hasTime) {
		String patternIn= "yyyy-MM-dd HH:mm:sss";
		if(date.length()<=10){
			patternIn = "yyyy-MM-dd";
		}
		if (hasTime) {
			return dateFormat(date, patternIn, "dd/MM/yyyy HH:mm:ss");
		}
		return dateFormat(date, patternIn, "dd-MM-yyyy");
	}
	
	
	
	public static Date getDateFromVNDate(String vnDate, boolean hasTime) {
		String patternIn = "dd/MM/yyyy HH:mm:ss";
		if(vnDate.length()<=10){
			patternIn = "dd/MM/yyyy";
		}
		String patternOut = "dd/MM/yyyy HH:mm:ss";
		if(!hasTime){
			patternOut = "dd/MM/yyyy";
		}
		return getDateFormat(vnDate, patternIn, patternOut);	
	}
	
	public static Date getDateFromDate(String date, boolean hasTime) {	
		String patternIn = "yyyy-MM-dd HH:mm:ss";
		if(date.length()<=10){
			patternIn = "yyyy-MM-dd";
		}
		String patternOut = "dd/MM/yyyy HH:mm:ss";
		if(!hasTime){
			patternOut = "dd/MM/yyyy";
		}
		return getDateFormat(date, patternIn, patternOut);	
		
	}
	
	public static String dateFormat(String date, String patternIn, String patternOut) {
		String vnDate = "";		
		SimpleDateFormat format = new SimpleDateFormat(patternOut);
			try {
			Date d = new SimpleDateFormat(patternIn).parse(date);			
			vnDate = format.format(d);
		} catch (Exception ex) {			
			return "";
		}
		return vnDate;
	}
	private static Date getDateFormat(String date, String patternIn, String patternOut) {
		Date d = null;
		try {
			d = new SimpleDateFormat(patternIn).parse(date);			
		} catch (Exception ex) {			
			return null;
		}
		return d;
	}

}
