package com.infore.platform.core.base;

import com.infore.platform.core.common.utils.Asserts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * All rights Reserved, Designed By www.infore.com
 *
 * @version V1.0
 * @Title: BaseFilter
 * @Package com.infore.platform.common.filter
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @author: xing.guanghui
 * @date: 2017/9/14 14:51
 * @company: 深圳盈峰环境网络技术有限公司
 * @Copyright: 2017 www.infore.com Inc. All rights reserved.
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
@Component
public abstract class BaseFilter extends OncePerRequestFilter {

    @Autowired
    protected Asserts asserts;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected abstract void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException ;

    protected void debug(String log) {
        log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
        this.logger.debug(log);
    }

    protected void debug(String log, Object value1) {
        log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
        this.logger.debug(log, value1);
    }

    protected void debug(String log, Object value1, Object value2) {
        log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
        this.logger.debug(log, value1, value2);
    }

    protected void debug(String log, Object... values) {
        log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
        this.logger.debug(log, values);
    }

    protected void info(String log) {
        log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
        this.logger.info(log);
    }

    protected void info(String log, Object value1) {
        log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
        this.logger.info(log, value1);
    }

    protected void info(String log, Object value1, Object value2) {
        log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
        this.logger.info(log, value1, value2);
    }

    protected void info(String log, Object... values) {
        log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
        this.logger.info(log, values);
    }

    protected void warn(String log) {
        log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
        this.logger.warn(log);
    }

    protected void warn(String log, Object value1) {
        log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
        this.logger.warn(log, value1);
    }

    protected void warn(String log, Object value1, Object value2) {
        log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
        this.logger.warn(log, value1, value2);
    }

    protected void warn(String log, Object... values) {
        log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
        this.logger.warn(log, values);
    }

    protected void error(String log) {
        log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
        this.logger.error(log);
    }

    protected void error(String log, Object value1) {
        log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
        this.logger.error(log, value1);
    }

    protected void error(String log, Object value1, Object value2) {
        log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
        this.logger.error(log, value1, value2);
    }

    protected void error(String log, Object... values) {
        log = "[RequestId: " + this.asserts.getRequestId() + "] " + log;
        this.logger.error(log, values);
    }
}
