package com.dfggweb.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 格式化的帮助类。
 * 
 * @author LiuBo
 * 
 */
public abstract class FormatHelper {

	public static final SimpleDateFormat DATETIMEFULL;

	/**
	 * 按yyyy-MM-dd HH:mm:ss格式来处理时间。
	 */
	public static final SimpleDateFormat DATETIME;

	/**
	 * 按yyyy-MM-dd格式来处理时间。
	 */
	public static final SimpleDateFormat DATE;

	public static final SimpleDateFormat TIMEFULL; 
	
	/**
	 * 按HH:mm:ss格式来处理时间。
	 */
	public static final SimpleDateFormat TIME;

	public static final DateFormat DATETIME_MEDIUM;

	public static final DateFormat DATETIME_SHORT;

	public static final DateFormat DATETIME_FULL;

	public static final DateFormat DATETIME_LONG;

	public static final DateFormat DATE_MEDIUM;

	public static final DateFormat DATE_SHORT;

	public static final DateFormat DATE_FULL;

	public static final DateFormat DATE_LONG;

	public static final DateFormat TIME_MEDIUM;

	public static final DateFormat TIME_SHORT;

	public static final DateFormat TIME_FULL;

	public static final DateFormat TIME_LONG;

	static {
		DATETIMEFULL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		DATETIMEFULL.setLenient(false);
		DATETIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DATETIME.setLenient(false);
		DATE = new SimpleDateFormat("yyyy-MM-dd");
		DATE.setLenient(false);
		TIMEFULL = new SimpleDateFormat("HH:mm:ss.SSS");
		TIMEFULL.setLenient(false);
		TIME = new SimpleDateFormat("HH:mm:ss");
		TIME.setLenient(false);
		DATETIME_MEDIUM = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
		DATETIME_MEDIUM.setLenient(false);
		DATETIME_SHORT = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		DATETIME_SHORT.setLenient(false);
		DATETIME_FULL = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);
		DATETIME_FULL.setLenient(false);
		DATETIME_LONG = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		DATETIME_LONG.setLenient(false);
		DATE_MEDIUM = DateFormat.getDateInstance(DateFormat.MEDIUM);
		DATE_MEDIUM.setLenient(false);
		DATE_SHORT = DateFormat.getDateInstance(DateFormat.SHORT);
		DATE_SHORT.setLenient(false);
		DATE_FULL = DateFormat.getDateInstance(DateFormat.FULL);
		DATE_FULL.setLenient(false);
		DATE_LONG = DateFormat.getDateInstance(DateFormat.LONG);
		DATE_LONG.setLenient(false);
		TIME_MEDIUM = DateFormat.getTimeInstance(DateFormat.MEDIUM);
		TIME_MEDIUM.setLenient(false);
		TIME_SHORT = DateFormat.getTimeInstance(DateFormat.SHORT);
		TIME_SHORT.setLenient(false);
		TIME_FULL = DateFormat.getTimeInstance(DateFormat.FULL);
		TIME_FULL.setLenient(false);
		TIME_LONG = DateFormat.getTimeInstance(DateFormat.LONG);
		TIME_LONG.setLenient(false);
	}

	/**
	 * 得到当前日期的格式化字符串
	 * 
	 * @param formatString
	 * 如：yyyy(年)-MM(月)-dd(日)-HH(时)-mm(分)-ss(秒)-SSS(毫秒)
	
	 * @return 格式化过的当前日期字符串
	 */
	public static String getCurrentFormatDate(String formatString) {
		Date now =new Date(System.currentTimeMillis());
		SimpleDateFormat sdf=new SimpleDateFormat(formatString);
		String ret=sdf.format(now);
		return ret;
	}
	
	/**
	 * 得到指定日期的格式化字符串
	 * @param date 指定的日期
	 * @param formatString
	 * 如：yyyy(年)-MM(月)-dd(日)-HH(时)-mm(分)-ss(秒)-SSS(毫秒)
	
	 * @return 格式化过的日期字符串
	 */
	public static String getFormatDate(Date date,String formatString) {		
		SimpleDateFormat sdf=new SimpleDateFormat(formatString);
		String ret=sdf.format(date);
		return ret;
	}
	
	/**
	 * 得到指定日期的最后时间
	 * @param date 指定的日期
	 * 如：xxxx-xx-xx 23:59:59
	
	 * @return 
	 */
	public static Date getFormatLastDate(Date date) {		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(c.HOUR, 23);
		c.set(c.MINUTE, 59);
		c.set(c.SECOND, 59);
		return c.getTime();
	}
	
	/**
	 * @param 无
	 * @return 当前日期
	 */
	public static Date getCurrentDate() {
		Date now =new Date(System.currentTimeMillis());
		return now;
	}
	/**
	 * 将格式化的日期字符串转换为日期。
	 * 
	 * @param dateString
	 * 	
	 * @return 字符串转换后的日期。
	 */
	public static Date formatDate(String dateString) {
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
			Date date=sdf.parse(dateString);
			return date;
		} catch (ParseException e) {			
			return null;
		}		
	}	
	
	/**
	 * 将格式化的日期字符串转换为日期。
	 * 
	 * @param dateString  日期字符串
	 * @param formatString
	 * 如：yyyy(年)-MM(月)-dd(日)-HH(时)-mm(分)-ss(秒)-SSS(毫秒)
	
	 * @return 字符串转换后的日期。
	 */
	public static Date formatDate(String dateString,String formatString) {
		try {
			SimpleDateFormat sdf=new SimpleDateFormat(formatString);	
			Date date=sdf.parse(dateString);
			return date;
		} catch (ParseException e) {
			return null;
		}		
	}
	
	/** 
     * 得到几天前的时间 
     *  
     * @param d 
     * @param day 
     * @return 
     */  
    public static Date getDateBefore(Date d, int day) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(d);  
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);  
        return now.getTime();  
    }  
    
    /** 
     * 得到几天前的时间 
     *  
     * @param d
     * @param day 
     * @return 
     */  
    public static String getDateBefore(String d, int day,String formatString) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(formatDate(d));  
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);  
        return getFormatDate(now.getTime(),formatString);  
    }
  
    /** 
     * 得到几天后的时间 
     *  
     * @param d 
     * @param day 
     * @return 
     */  
    public static Date getDateAfter(Date d, int day) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(d);  
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);  
        return now.getTime();  
    } 
    
    /** 
     * 得到几天后的时间 
     *  
     * @param d 
     * @param day 
     * @return 
     */  
    public static String getDateAfter(String d, int day, String formatString) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(formatDate(d));  
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);  
        return getFormatDate(now.getTime(),formatString);  
    } 
}
