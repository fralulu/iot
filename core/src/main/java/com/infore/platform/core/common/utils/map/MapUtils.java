/******************************************************************************
 * All Rights Reserved.
 * 本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.infore.platform.core.common.utils.map;

import com.infore.platform.core.common.utils.sql.SQLUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.infore.com
 *
 * @version V1.0
 * @Title: MapUtils.java
 * @Package com.infore.platform.core.common.utils.map
 * @Description: 适用于db层 数据处理
 * @author: Administrator
 * @date: 2017年9月5日 下午8:06:08
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2017 www.infore.com Inc. All rights reserved.
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
public class MapUtils {
    /**
     * 获取整型值
     *
     * @param map map
     * @param key key
     * @return int
     */
    public static int getInt(Map<String, Object> map, String key) {
        return map.get(key) == null ? 0 : (Integer) map.get(key);
    }

    /**
     * 获取浮点数值
     *
     * @param map map
     * @param key key
     * @return float
     */
    public static float getFloat(Map<String, Object> map, String key) {
        return map.get(key) == null ? 0 : (Float) map.get(key);
    }

    /**
     * 获取浮点数值
     *
     * @param map map
     * @param key key
     * @return double
     */
    public static double getDouble(Map<String, Object> map, String key) {
        return map.get(key) == null ? 0 : (Double) map.get(key);
    }

    /**
     * 获取string值
     *
     * @param map map
     * @param key key
     * @return string
     */
    public static String getString(Map<String, Object> map, String key) {
        return map.get(key) == null ? "" : (String) map.get(key);
    }

    /**
     * 获取布尔值
     *
     * @param map map
     * @param key key
     * @return boolean
     */
    public static boolean getBoolean(Map<String, Object> map, String key) {
        return map.get(key) == null ? false : (Boolean) map.get(key);
    }

    /**
     * 获取布尔值
     *
     * @param map map
     * @param key key
     * @return char
     */
    public static char getChar(Map<String, Object> map, String key) {
        return map.get(key) == null ? null : (Character) map.get(key);
    }

    /**
     * 获取java.utils.date值
     *
     * @param map map
     * @param key key
     * @return date
     */
    public static java.util.Date getUtilDate(Map<String, Object> map, String key) {
        return map.get(key) == null ? null : (java.util.Date) map.get(key);
    }

    /**
     * 获取java.utils.date值
     *
     * @param map map
     * @param key key
     * @return timestamp
     */
    public static java.sql.Timestamp getTimestamp(Map<String, Object> map, String key) {
        return map.get(key) == null ? null : (java.sql.Timestamp) map.get(key);
    }

    /**
     * 获取java.utils.date值
     *
     * @param map map
     * @param key key
     * @return string
     */
    public static String getClob(Map<String, Object> map, String key) {
        java.sql.Clob clob = (java.sql.Clob) map.get(key);
        return SQLUtils.clob2string(clob);
    }

    /**
     * 将Map中的date，clob进行数据格式转换
     *
     * @param map map
     */
    public static void dateFormat(Map<String, Object> map) {
        dataFormat(map, "yyyy-MM-dd");
    }

    /**
     * 将Map中的date，clob进行数据格式转换
     *
     * @param map         数据集
     * @param datePattern 日期格式
     */
    public static void dataFormat(Map<String, Object> map, String datePattern) {
        if (null != map) {
            for (String key : map.keySet()) {
                if (map.get(key) instanceof java.sql.Timestamp) { // timestamp
                    java.sql.Timestamp objDate = (java.sql.Timestamp) map.get(key);
                    String strDate = DateFormatUtils.format(objDate.getTime(), datePattern);
                    map.put(key, strDate);
                } else if (map.get(key) instanceof java.sql.Date) { // sql date
                    java.sql.Date objDate = (java.sql.Date) map.get(key);
                    String strDate = DateFormatUtils.format(objDate.getTime(), datePattern);
                    map.put(key, strDate);
                } else if (map.get(key) instanceof java.util.Date) { // util date
                    java.util.Date objDate = (java.util.Date) map.get(key);
                    String strDate = DateFormatUtils.format(objDate.getTime(), datePattern);
                    map.put(key, strDate);
                } else if (map.get(key) instanceof java.sql.Clob) {
                    java.sql.Clob clob = (java.sql.Clob) map.get(key);
                    String clobString = SQLUtils.clob2string(clob);
                    map.put(key, clobString);
                }
            }
        }
    }

    /**
     * 格式化日期字段格式为 yyyy-MM-dd HH:mm:ss
     * @param map map
     */
    public static void dateTimeFormat(Map<String, Object> map) {
        dataFormat(map, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 格式化日期字段格式为 yyyy-MM-dd HH:mm:ss
     * @param list 列表
     */
    public static void dataFormat4List(List<Map<String, Object>> list) {
        dataFormat4List(list, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 将查询出的list 中时间格式进行处理
     *
     * @param list        列表
     * @param dataPattern 格式
     */
    public static void dataFormat4List(List<Map<String, Object>> list, String dataPattern) {
        if (list != null && list.size() > 0) {
            for (Map<String, Object> map : list) {
                dataFormat(map, dataPattern);
            }
        }
    }
}
