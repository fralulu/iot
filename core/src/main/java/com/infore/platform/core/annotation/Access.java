package com.infore.platform.core.annotation;

import java.lang.annotation.*;

/**
 * All rights Reserved, Designed By www.infore.com
 *
 * @version V1.0
 * @Title: ElasticsearchConfig
 * @Package com.infore.platform.common.config
 * @Description: 权限
 * @author: xing.guanghui
 * @date: 2017/10/31 15:00
 * @company: 深圳盈峰环境网络技术有限公司
 * @Copyright: 2017 www.infore.com Inc. All rights reserved.
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Access {

    String value() default "";

    String[] roles() default {};
}
