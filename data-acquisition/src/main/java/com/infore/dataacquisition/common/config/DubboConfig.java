package com.infore.dataacquisition.common.config;

/******************************************************************************
 * All Rights Reserved.
 * 本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**  
 * All rights Reserved, Designed By www.infore.com
 * @Title:  DubboConfig.java   
 * @Package com.infore.platform.common.config   
 * @Description:    zk dubbo配置
 * @author: Administrator  
 * @date:   2017年9月8日 上午10:59:22   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2017 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
//@Configuration
@ImportResource({"classpath:dubbo/*.xml" })
public class DubboConfig {

}
