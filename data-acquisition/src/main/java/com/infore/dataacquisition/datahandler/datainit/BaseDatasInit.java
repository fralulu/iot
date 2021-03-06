/******************************************************************************
 * All Rights Reserved.
 * 本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.infore.dataacquisition.datahandler.datainit;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infore.dataacquisition.datahandler.service.IReceiveService;

/**  
 * All rights Reserved, Designed By www.infore.com
 * @Title:  BaseDatasInit.java   
 * @Package com.infore.dataacquisition.datahandler.datainit   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: deer
 * @date:   2018年7月2日 下午3:01:52   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2018 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
@Component
public class BaseDatasInit {
   protected static final Logger logger = LoggerFactory.getLogger(BaseDatasInit.class);
	
	@Autowired
	private IReceiveService receiveService;
	
    @PostConstruct
    public void init() {
	  logger.info("base data init......");
	  receiveService.getAllStationInstance();
	  receiveService.getAllProjectInstance();
	  logger.info("base data end!");
    }
}
