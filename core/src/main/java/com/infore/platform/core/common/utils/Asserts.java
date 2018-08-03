package com.infore.platform.core.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * All rights Reserved, Designed By www.infore.com
 *
 * @version V1.0
 * @Title: Asserts
 * @Package com.infore.platform.core.common.utils
 * @Description: 日志封装requestId
 * @author: xing.guanghui
 * @date: 2017/9/14 14:47
 * @company: 深圳盈峰环境网络技术有限公司
 * @Copyright: 2017 www.infore.com Inc. All rights reserved.
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
public class Asserts {

    @SuppressWarnings("unused")
	private Logger logger;
    private String requestId;

    public Asserts() {
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
