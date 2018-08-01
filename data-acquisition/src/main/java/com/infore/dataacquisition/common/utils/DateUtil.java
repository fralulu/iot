/**
 * 时间处理公共函数
 */
package com.infore.dataacquisition.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * @author Ray
 * 
 */
public class DateUtil {
	static String format1 = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 
	 * @Title: dateToString
	 * @Description: 时间转化为String类型
	 * @date 2017年6月8日
	 * @author leitao
	 */
	public static String dateToString(Date time, String format) {
		if (StringUtils.isBlank(format)) {
			format = format1;
		}
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(time);
	}

	/**
	 * 
	 * @Title: StringTodate
	 * @Description: String转化为时间
	 * @date 2017年6月8日
	 * @author leitao
	 */
	public static Date StringTodate(String time1, String format2) {
		if (StringUtils.isBlank(format2)) {
			format2 = format1;
		}
		SimpleDateFormat format = new SimpleDateFormat(format2);
		Date date = null;
		try {
			date = format.parse(time1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 
	 * @Title: formatDate
	 * @Description: 时间格式化
	 * @date 2017年6月8日
	 * @author leitao
	 */
	public static Date formatDate(Date time1, String format2) {
		if (StringUtils.isBlank(format2)) {
			format2 = format1;
		}
		SimpleDateFormat format = new SimpleDateFormat(format2);
		Date date = null;
		try {
			date = format.parse(format.format(time1));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 时间加减
	 * 
	 * @param date
	 *            日期
	 * @param day
	 *            天数
	 * @return 返回加减后的日期
	 * @date 2017年7月12日
	 * @author zw
	 */
	public static Date addDate(Date date, int diff) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) + ((long) diff) * 24 * 3600 * 1000);
		return c.getTime();
	}

	public static Date addHour(Date date, int diff) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) + ((long) diff) * 3600 * 1000);
		return c.getTime();
	}

	public static Date addMonth(Date date, int diff) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, diff);
		return c.getTime();
	}

	public static Date addYear(Date date, int diff) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, diff);
		return c.getTime();
	}

	/**
	 * 获取毫秒数
	 * 
	 * @date 2017年7月12日
	 * @author zw
	 */
	public static long getMillis(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}
	
	
	/**
	 * 
	* @Description: 获取时间范围内天 或月份
	* @param startTime
	* @param endTime
	* @param timeType day month
	* @return 
	* @date 2017年11月15日
	* @author cys
	* @return
	 */
	public static List<String> getTimeRanking(Date startTime,Date endTime,String timeType){
		Calendar c1 = Calendar.getInstance();
		c1.setTime(startTime);
		
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		
		Calendar c2 = Calendar.getInstance();
		c2.setTime(endTime);
	
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.SECOND, 0);
		 List<String> result = new ArrayList<>();
		 
		 SimpleDateFormat sim = new SimpleDateFormat();
		if(timeType.equals("day")){
			//获取天数
			c1.set(Calendar.HOUR_OF_DAY, 0);
			c2.set(Calendar.HOUR_OF_DAY, 0);
			 sim = new SimpleDateFormat("yyyy-MM-dd");
			while(c1.getTimeInMillis()<=c2.getTimeInMillis()){
				result.add(sim.format(c1.getTime()));
				c1.add(Calendar.DAY_OF_MONTH, 1);
			}
		}else if(timeType.equals("month")){
			//获取月份
			 sim = new SimpleDateFormat("yyyy-MM");
			c1.set(Calendar.DAY_OF_MONTH, 1);
			c2.set(Calendar.DAY_OF_MONTH, 1);
			while(c1.getTimeInMillis()<=c2.getTimeInMillis()){

				result.add(sim.format(c1.getTime()));
				c1.add(Calendar.MONTH, 1);
			}
		}else if(timeType.equals("hour")){
			//获取小时
			 sim = new SimpleDateFormat("yyyy-MM-dd HH");
			while(c1.getTimeInMillis()<=c2.getTimeInMillis()){

				result.add(sim.format(c1.getTime()));
				c1.add(Calendar.HOUR_OF_DAY, 1);
			}
		}else if(timeType.equals("year")){
			//获取年
			 sim = new SimpleDateFormat("yyyy");
			c1.set(Calendar.MONTH, 1);
			c2.set(Calendar.MONTH, 1);
			c1.set(Calendar.DAY_OF_MONTH, 1);
			c2.set(Calendar.DAY_OF_MONTH, 1);
			c1.set(Calendar.HOUR_OF_DAY, 0);
			c2.set(Calendar.HOUR_OF_DAY, 0);
			while(c1.getTimeInMillis()<=c2.getTimeInMillis()){
				result.add(sim.format(c1.getTime()));
				c1.add(Calendar.YEAR, 1);
			}
		}
		
		
		
		
		
		
		return result;
	}
}
