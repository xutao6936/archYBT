package com.topcheer.ybt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * @ClassName: DateUtil 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author XUTAO 
 * @date 2016-6-8 下午03:43:10 
 *  
 */
public class DateUtil {

	private static final int ONE_DAY_SECONDS = 60 * 60 * 24;

	private static final int MILLISECOND = 1000;

	private static final String DATE_FORMAT_1 = "yyyyMMdd";

	private static final String DATE_FORMATE_2 = "yyyy-MM-dd";

	private static final String TIME_FORMAT = "HHmmss";
	private static final String TIME_FORMAT_S = "HH:mm:ss";

	private static final String PRINT_FORMAT = "yyyy-MM-dd HH:mm:ss";

	private static final String LOGIN_FORMAT = "yyyyMMddHHmmss";	

	private static final SimpleDateFormat dateFormat1 = new SimpleDateFormat(
			DATE_FORMAT_1);

	private static final SimpleDateFormat timeFormat1 = new SimpleDateFormat(
			TIME_FORMAT);
	
	private static final SimpleDateFormat timeFormat2 = new SimpleDateFormat(
			TIME_FORMAT_S);

	private static final SimpleDateFormat dateFormate2 = new SimpleDateFormat(
			DATE_FORMATE_2);
	private static final SimpleDateFormat dateTimeFormate1 = new SimpleDateFormat(PRINT_FORMAT);

	private DateUtil() {
	}

	/**
	 * @return 得到系统当日日期，其中日期的格式为：yyyyMMdd，例如：20051101
	 */
	public static String getCurrentDate() {
		
			return formatDate(new Date());
		
	}
	
	public static String getCurrentDate1(){//FIXME 生产环境修要修改
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date today = new Date();
		String sDate = dateFormat.format(today);
		return sDate;
	}
	
	public static String getCurrentDate2(){
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMATE_2);
		Date today = new Date();
		String sDate = dateFormat.format(today);
		return sDate;
	}
	/**
	 * @return 得到系统当日日期，其中日期的格式为：HHmmss，例如：112003
	 */
	public static String getCurrentTime() {
		return formatTime(new Date());
	}
	
	/**
	 * @return 得到系统当日日期，其中日期的格式为：HHmmss，例如：11:20:03
	 */
	public static String getCurrentTime_S() {
		return formatTime_S(new Date());
	}

	/**
	 * @param date
	 * @return
	 */
	public static String formatTime(Date date) {
		synchronized (dateFormat1) {
			return timeFormat1.format(date);
		}
	}
	
	/**
	 * @param date
	 * @return
	 */
	public static String formatTime_S(Date date) {
		synchronized (dateFormat1) {
			return timeFormat2.format(date);
		}
	}

	/**
	 * @return 系统当日日期，其中日期的格式为：yyyyMMdd，例如：20051101
	 */
	public static String getToday() {
		
			return formatDate(new Date());
			
	}

	public static String getCurrentMonth(){
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		return format.format(new Date());
	}
	
	
	public static String getCurrentYear(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		return format.format(new Date());
	}
	/**
	 * 格式为:yyyy-MM-dd
	 */
	public static String getToday2() {
		synchronized (dateFormate2) {
			return dateFormate2.format(new Date());
		}
	}
	
	/**
	 * 格式为yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getDateTime1(){
		synchronized (dateTimeFormate1) {
			return dateTimeFormate1.format(new Date());
		}
	}

	public static String formatDate(Date date, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}

	/**
	 * 
	 * @return 系统当日的下一个日期，其中日期的格式为：yyyyMMdd，例如：20051102
	 */
	public static String getTomorrow() {
		Date date = new Date();
		long time = date.getTime() / MILLISECOND + ONE_DAY_SECONDS;
		date.setTime(time * MILLISECOND);
		return formatDate(date);
	}

	/**
	 * 
	 * @return 系统当日的上一个日期，其中日期的格式为：yyyyMMdd，例如：20051102
	 */
	public static String getYestoday() {
		
			Date date = new Date();
			long time = date.getTime() / MILLISECOND - ONE_DAY_SECONDS;
			date.setTime(time * MILLISECOND);
			return formatDate(date);
			
	}
	
	/**
	 * 根据开始日期及日期间隔，取结束日期
	 * 
	 * @param startDate
	 *            开始日期，其中日期的格式为：yyyyMMdd，例如：20051101
	 * @param interval
	 *            日期间隔 表示间隔天数，例如：9
	 * @return 结束日期 开始日期加间隔日期的结果，其中日期的格式为：yyyyMMdd，例如：20051110
	 * @throws ParseException
	 *             日期格式不正确的解析异常
	 */
	public static String getEndDate(String startDate, int interval)
			throws ParseException {
		Date today = parseDate(startDate);
		long time = today.getTime() / MILLISECOND + ONE_DAY_SECONDS * interval;
		today.setTime(time * MILLISECOND);
		String sDate = formatDate(today);
		return sDate;
	}

	public static String formatDate(Date date) {
		synchronized (dateFormat1) {
			return dateFormat1.format(date);
		}
	}

	public static Date parseDate(String date) throws ParseException {
		synchronized (dateFormat1) {
			return dateFormat1.parse(date);
		}
	}

	/**
	 * 取开始日期与结束日期之间的间隔日期
	 * 
	 * @param startDate
	 *            开始日期，其中日期的格式为：yyyyMMdd，例如：20051101
	 * @param endDate
	 *            结束日期，其中日期的格式为：yyyyMMdd，例如：200511010
	 * @return 日期间隔 表示间隔天数，例如：9
	 * @throws ParseException
	 *             日期格式不正确的解析异常
	 */
	public static int getInterval(String startDate, String endDate)
			throws ParseException {
		Date sDate = parseDate(startDate);
		Date eDate = parseDate(endDate);
		long sTime = sDate.getTime() / MILLISECOND;
		long eTime = eDate.getTime() / MILLISECOND;
		return (int) (eTime - sTime) / ONE_DAY_SECONDS;
	}

	/**
	 * 
	 * @param date
	 *            格式必须为yyyymmdd,如:20060410
	 * @return 返回月和日,如: 04月10日
	 */
	public static String getMonthAndDay(String date) {
		return date.substring(4, 6) + "月" + date.substring(6, 8) + "日";
	}

	public static void main(String[] args) {
	}
	
	
}
