package com.infore.platform.core.common.utils.date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * All rights Reserved, Designed By www.infore.com
 *
 * @version V1.0
 * @Title: DateUtils
 * @Package com.infore.platform.core.common.utils.date
 * @Description: 日期工具类 基于java8 time包
 * @author: xing.guanghui
 * @date: 2017/8/18 13:28
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2017 www.infore.com Inc. All rights reserved.
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
public class DateUtils {
    private static ZoneId zone = ZoneId.systemDefault();

    /**
     * 字符串转Date
     * @param date 日期字符串 yyyy-MM-dd
     * @return 转化后的日期
     */
    public static Date convertToDate(String date) {
        LocalDate localDate;
        if (null == date) {
            return null;
        } else {
            localDate = LocalDate.parse(date);
            return convertToDate(localDate);
        }
    }

    /**
     * 字符串转Date
     *
     * @param date 时间字符串 yyyy-MM-dd HH:mm:ss
     * @return Date
     */
    public static Date convertToDateTime(String date) {
        LocalDateTime localDateTime;
        if (null == date) {
            return null;
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            localDateTime = LocalDateTime.parse(date, formatter);
            return convertToDate(localDateTime);
        }
    }

    /**
     * 字符串转Timestamp
     * @param date 日期字符串 yyyy-MM-dd
     * @return 转化后的时间戳
     */
    public static Timestamp convertToTimestamp(String date) {
        if (null == date) {
            return null;
        } else {
            LocalDate localDate = LocalDate.parse(date);
            return Timestamp.valueOf(localDate.atStartOfDay());
        }
    }

    /**
     * 字符串转Timestamp
     *
     * @param date 时间字符串 yyyy-MM-dd HH:mm:ss
     * @return Timestamp
     */
    public static Timestamp convertToTimestamp2(String date) {
        if (null == date) {
            return null;
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
            return Timestamp.valueOf(localDateTime);
        }
    }

    /**
     * Long 转 Timestamp
     *
     * @param epochMilli long
     * @return Timestamp
     */
    public static Timestamp convertToTimestamp(Long epochMilli) {
        if (null == epochMilli) {
            return null;
        } else {
            return Timestamp.from(Instant.ofEpochMilli(epochMilli));
        }
    }

    /**
     * 字符串转LocalDateTime
     *
     * @param date 时间字符串 yyyy-MM-dd HH:mm:ss
     * @return localDateTime
     */
    public static LocalDateTime convertToLocalDateTime(String date) {
        LocalDateTime localDateTime;
        if (null == date) {
            return null;
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            localDateTime = LocalDateTime.parse(date, formatter);
            return localDateTime;
        }
    }

    /**
     * LocalDate转Date
     *
     * @param localDate 日期
     * @return Date
     */
    public static Date convertToDate(LocalDate localDate) {
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * LocalDate转Date
     *
     * @param localDateTime 时间
     * @return Date
     */
    public static Date convertToDate(LocalDateTime localDateTime) {
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * String转LocalDate
     *
     * @param date 日期
     * @return localDate
     */
    public static LocalDate convertToLocalDate(String date) {
        return LocalDate.parse(date);
    }

    /**
     * Date转LocalDate
     *
     * @param date 日期
     * @return localDate
     */
    public static LocalDate convertToLocalDate(Date date) {
        Instant instant = date.toInstant();
        return convertToLocalDateTime(instant).toLocalDate();
    }

    /**
     * Date转LocalTime
     *
     * @param date 日期
     * @return localDate
     */
    public static LocalTime convertToLocalTime(Date date) {
        Instant instant = date.toInstant();
        return convertToLocalDateTime(instant).toLocalTime();
    }

    /**
     * Date转LocalDatetime
     *
     * @param date 日期
     * @return localDate
     */
    public static LocalDateTime convertToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        return convertToLocalDateTime(instant);
    }


    /**
     * Instant转LocalDateTime
     *
     * @param instant instant
     * @return LocalDateTime
     */
    public static LocalDateTime convertToLocalDateTime(Instant instant) {
        return LocalDateTime.ofInstant(instant, zone);
    }

    /**
     * LocalDateTime转Instant
     *
     * @param localDateTime 时间
     * @return Instant
     */
    public static Instant convertToInstant(LocalDateTime localDateTime) {
        return localDateTime.atZone(zone).toInstant();
    }

    /**
     * LocalDate转Instant
     *
     * @param localDate 日期
     * @return Instant
     */
    public static Instant convertToInstant(LocalDate localDate) {
        return localDate.atStartOfDay(zone).toInstant();
    }

    /**
     * LocalDate转LocalDateTime
     *
     * @param localDate 日期
     * @return LocalDateTime
     */
    public static LocalDateTime convertToLocalDateTime(LocalDate localDate) {
        return localDate.atStartOfDay();
    }

    /**
     * 日周期格式化
     *
     * @param localDateTime 日期
     * @param formatStyle   格式
     * @return 格式化后的字符串
     */
    public static String formatter(LocalDateTime localDateTime, String formatStyle) {
        return DateTimeFormatter.ofPattern(formatStyle).format(localDateTime);
    }

    /**
     * 设置年
     *
     * @param sourceDate 源日期
     * @param year       年份
     * @return LocalDateTime
     */
    public static LocalDateTime setYear(LocalDateTime sourceDate, Integer year) {
        return sourceDate.withYear(year);
    }

    /**
     * 设置月
     *
     * @param sourceDate 源日期
     * @param month      月份
     * @return LocalDateTime
     */
    public static LocalDateTime setMonth(LocalDateTime sourceDate, Integer month) {
        return sourceDate.withMonth(month);
    }

    /**
     * 设置天
     *
     * @param sourceDate 源日期
     * @param dayOfMonth 天
     * @return LocalDateTime
     */
    public static LocalDateTime setDayOfMonth(LocalDateTime sourceDate, Integer dayOfMonth) {
        return sourceDate.withDayOfMonth(dayOfMonth);
    }

    /**
     * 设置小时
     *
     * @param sourceDate 源日期
     * @param hour       小时
     * @return LocalDateTime
     */
    public static LocalDateTime setHour(LocalDateTime sourceDate, Integer hour) {
        return sourceDate.withHour(hour);

    }

    /**
     * 设置分钟
     *
     * @param sourceDate 源日期
     * @param minute     分钟数
     * @return LocalDateTime
     */
    public static LocalDateTime setMinute(LocalDateTime sourceDate, Integer minute) {
        return sourceDate.withMinute(minute);
    }

    /**
     * 设置秒
     *
     * @param sourceDate 源日期
     * @param second     秒
     * @return LocalDateTime
     */
    public static LocalDateTime setSecond(LocalDateTime sourceDate, Integer second) {
        return sourceDate.withSecond(second);
    }

    /**
     * 修改年月日
     *
     * @param sourceDate 源日期
     * @param year       年
     * @param month      月
     * @param dayOfMonth 日
     * @return LocalDateTime
     */
    public static LocalDateTime setYMD(LocalDateTime sourceDate, Integer year, Integer month, Integer dayOfMonth) {
        return sourceDate.withYear(year).withMonth(month).withDayOfMonth(dayOfMonth);
    }

    /**
     * 修改时分秒
     *
     * @param sourceDate 源日期
     * @param hour       时
     * @param minute     分
     * @param second     秒
     * @return LocalDateTime
     */
    public static LocalDateTime setHMS(LocalDateTime sourceDate, Integer hour, Integer minute, Integer second) {
        return sourceDate.withHour(hour).withMinute(minute).withSecond(second);
    }

    /**
     * 计算相差的天数
     *
     * @param beginDate 起始时间
     * @param endDate   结束时间
     * @return 相差的天数
     */
    public static int getInteverDays(LocalDate beginDate, LocalDate endDate) {
        Period period = Period.between(beginDate, endDate);
        return period.getDays();
    }

    /**
     * 日期加减
     *
     * @param num       数量
     * @param unit      单位
     * @param localDate 原日期
     * @return 增加后的日期
     */
    public static LocalDate addLocalDate(long num, ChronoUnit unit, LocalDate localDate) {
        LocalDate resultDate;
        if (num > 0) {
            resultDate = LocalDate.now().plus(num, unit);
        } else {
            resultDate = LocalDate.now().minus(Math.abs(num), unit);
        }
        return resultDate;
    }

    /**
     * 日期时分秒加
     *
     * @param num           数量
     * @param unit          单位
     * @param localDateTime 原日期
     * @return 增加后的日期
     */
    public static LocalDateTime addLocalDateTime(long num, ChronoUnit unit, LocalDateTime localDateTime) {
        LocalDateTime resultDateTime;
        if (num > 0) {
            resultDateTime = localDateTime.plus(num, unit);
        } else {
            resultDateTime = localDateTime.minus(Math.abs(num), unit);
        }
        return resultDateTime;
    }

    /**
     * 加减指定单位的时间
     *
     * @param num       数量
     * @param unit      单位
     * @param localTime 原日期
     * @return 增加后的日期
     */
    public static LocalTime addLocalTime(long num, ChronoUnit unit, LocalTime localTime) {
        return localTime.plus(num, unit);
    }

    /**
     * @Title: dateToString
     * @Description: date类型转换为String类型
     * @author: ZengXiaoming
     * @param data Date类型的时间
     * @param formatType 格式为yyyy-MM-dd HH:mm:ss；yyyy年MM月dd日 HH时mm分ss秒
     * @return
     */
    public static String dateToString(Date data, String formatType) {
        return new SimpleDateFormat(formatType).format(data);
    }

    /**
     * @Title: longToString
     * @Description: long类型转换为String类型
     * @author: ZengXiaoming
     * @param currentTime 要转换的long类型的时间
     * @param formatType 要转换的string类型的时间格式
     * @return
     * @throws ParseException
     */
    public static String longToString(long currentTime, String formatType)
            throws ParseException {
        // long类型转成Date类型
        Date date = longToDate(currentTime, formatType);
        // date类型转成String
        String strTime = dateToString(date, formatType);
        return strTime;
    }

    /**
     * @Title: stringToDate
     * @Description: string类型转换为date类型
     * @author: ZengXiaoming
     * @param strTime 要转换的string类型的时间，时间格式必须要与formatType的时间格式相同
     * @param formatType 要转换的格式yyyy-MM-dd HH:mm:ss；yyyy年MM月dd日 HH时mm分ss秒
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String strTime, String formatType)
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }

    /**
     * @Title: longToDate
     * @Description: long转换为Date类型
     * @author: ZengXiaoming
     * @param currentTime 要转换的long类型的时间
     * @param formatType 要转换的时间格式yyyy-MM-dd HH:mm:ss；yyyy年MM月dd日 HH时mm分ss秒
     * @return
     * @throws ParseException
     */
    public static Date longToDate(long currentTime, String formatType)
            throws ParseException {
        // 根据long类型的毫秒数生命一个date类型的时间
        Date dateOld = new Date(currentTime);
        // 把date类型的时间转换为string
        String sDateTime = dateToString(dateOld, formatType);
        // 把String类型转换为Date类型
        return stringToDate(sDateTime, formatType);
    }

    /**
     * @Title: stringToLong
     * @Description: String类型转换为long类型
     * @author: ZengXiaoming
     * @param strTime 要转换的String类型的时间，strTime的时间格式和formatType的时间格式必须相同
     * @param formatType 时间格式
     * @return
     * @throws ParseException
     */
    public static long stringToLong(String strTime, String formatType)
            throws ParseException {
        // String类型转成date类型
        Date date = stringToDate(strTime, formatType);
        if (date == null) {
            return 0;
        } else {
            // date类型转成long类型
            long currentTime = dateToLong(date);
            return currentTime;
        }
    }

    /**
     * @Title: dateToLong
     * @Description: date类型转换为long类型
     * @author: ZengXiaoming
     * @param date 要转换的date类型的时间
     * @return
     */
    public static long dateToLong(Date date) {
        return date.getTime();
    }
}
