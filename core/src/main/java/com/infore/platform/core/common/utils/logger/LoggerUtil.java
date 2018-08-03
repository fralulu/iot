package com.infore.platform.core.common.utils.logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * All rights Reserved, Designed By www.infore.com
 *
 * @version V1.0
 * @Title: LoggerUtil.java
 * @Package com.infore.platform.core.common.utils.logger
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: Administrator
 * @date: 2017年8月22日 下午2:33:34
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2017 www.infore.com Inc. All rights reserved.
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
public final class LoggerUtil {
    private LoggerUtil() {
    }

    /**
     * @param clazz class
     * @param msg   msg
     * @param ex    exception
     * @Title: debug
     * @Description: debug日志
     * @return: void
     */
    @SuppressWarnings("rawtypes")
    public static void debug(Class clazz, String msg, Exception ex) {
        Log logger = LogFactory.getLog(clazz);
        if (logger.isDebugEnabled()) {
            if (null != ex) {
                logger.debug(msg, ex);
            } else {
                logger.debug(msg);
            }
        }
    }

    /**
     * @param clazz class
     * @param msg   msg
     * @param ex    exception
     * @Title: info
     * @Description: info日志
     * @return: void
     */
    @SuppressWarnings("rawtypes")
    public static void info(Class clazz, String msg, Exception ex) {
        Log logger = LogFactory.getLog(clazz);
        if (null != ex) {
            logger.info(msg, ex);
        } else {
            logger.info(msg);
        }
    }

    /**
     * @param clazz class
     * @param msg   msg
     * @param ex    exception
     * @Title: error
     * @Description: error日志
     * @return: void
     */
    @SuppressWarnings("rawtypes")
    public static void error(Class clazz, String msg, Exception ex) {
        Log logger = LogFactory.getLog(clazz);
        if (logger.isErrorEnabled()) {
            if (null != ex) {
                logger.error(msg, ex);
            } else {
                logger.error(msg);
            }
        }
    }

}