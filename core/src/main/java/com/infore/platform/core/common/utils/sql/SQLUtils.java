package com.infore.platform.core.common.utils.sql;

import com.infore.platform.core.common.utils.logger.LoggerUtil;

import java.sql.Clob;
import java.sql.SQLException;
import java.util.Map;

/**
 * 
 * All rights Reserved, Designed By www.infore.com
 * @Title:  SQLUtils.java   
 * @Package com.infore.platform.core.common.utils.map   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: Administrator  
 * @date:   2017年9月5日 下午8:08:14   
 * @version V1.0 
 * @company: 深圳盈峰环境网络技术有限公司
 * @Copyright: 2017 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
public class SQLUtils {

    /**
     * 定义为单例
     */
    private SQLUtils() {
    }

    /**
     * 判断MAP中是否包含KEY，并为该值追加%
     * 
     * @param condition map
     * @param key key
     * @param before
     *            是否在值得前面增加%
     * @param behind
     *            是否在值得后面增加%
     */
    public static void fillLike(Map<String, Object> condition, String key, boolean before, boolean behind) {
        if (null != condition && condition.containsKey(key)) {
            if (before) {
                condition.put(key, "%" + condition.get(key));
            }
            if (behind) {
                condition.put(key, condition.get(key) + "%");
            }
        }
    }

    /**
     * 判断MAP中是否包含KEY，并为该值前后追加%
     * 
     * @param condition map
     * @param key key
     */
    public static void fillLike(Map<String, Object> condition, String key) {
        if (null != condition && condition.containsKey(key)) {
            condition.put(key, "%" + condition.get(key) + "%");
        }
    }

    /**
     * clob转string
     * @param clob clob
     * @return string
     */
    public static String clob2string(Clob clob) {
        String value = "";
        if (null != clob) {
            try {
                value = clob.getSubString(1, (int) clob.length());
            } catch (SQLException ex) {
                LoggerUtil.error(SQLUtils.class, "Clob转String异常", ex);
            }
        }
        return value;
    }

    /**
     * clob转string
     * @param data map
     */
    public static void clob2string(Map<String, Object> data) {
        for (String key : data.keySet()) {
            if (data.get(key) instanceof Clob) {
                Clob clobData = (Clob) data.get(key);
                data.put(key, clob2string(clobData));
            }
        }
    }

}