package com.infore.dataacquisition.common.utils;


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间转换格式类型，可在原有基础上自行添加
 * @author zwt
 *
 */
public class FormatUtil {

	public final static String SECOND_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
	public final static String HOUR_DATE_FORMAT="MM-dd HH:mm";
	public final static String DAY_DATE_FORMAT="yyyy-MM-dd";
	public final static String MINUTE_DATE_FORMAT="yyyy-MM-dd HH:mm";
	public final static String YEAR_DATE_FORMAT="yyyy-MM";
	public final static String SECOND="yyyyMMddHHmmss";
	public final static String MINUTE="yyyyMMddHHmm";
	public final static String HOUR="yyyyMMddHH";
	public final static String DAY="yyyyMMdd";
	public final static String MONTH="yyyyMM";
	public final static String MILLISECOND="yyyyMMddHHmmssSSS";
	
	
	
	//获取设定格式时间字符串
	public static String getdateFormat(String format,Date date){
		return new SimpleDateFormat(format).format(date);
	}
	
	//转化指定格式时间串
	public static Date getDate(String format,String date) throws ParseException{
		return new SimpleDateFormat(format).parse(date);
	}
	
	/**
	 * 除法运算
	 * @Title: divided
	 * @Description: TODO
	 * @date 2016年5月30日 下午4:55:46
	 * @author  周文涛
	 */
	public static Double divided( double dividend, double divisor, int digit ) {
		Double result = 0.0;
		if ( divisor != 0L ) {
			result = dividend / divisor;
		}
		if ( digit < 0 ) {
			digit = 0;
		}
		BigDecimal bd = new BigDecimal(result);
		return bd.setScale(digit, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/**
	 * 获取适当小数位数
	 * @Title: scale
	 * @Description: TODO
	 * @date 2016年5月31日 下午5:53:58
	 * @author  周文涛
	 */
	public static Double scale(Double value,Integer digit){
		if(digit==null){
			digit=new Integer(4);
		}
		BigDecimal bd = new BigDecimal(value);
		return bd.setScale(digit, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public static void main(String[] args) {
		System.out.println(divided(9,10,2));
	}
	
}
