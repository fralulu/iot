/******************************************************************************
 * All Rights Reserved.
 * 本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.infore.dataacquisition.common.listener;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.infore.dataacquisition.datahandler.job.SchedulerAllJobs;

/**  
 * All rights Reserved, Designed By www.infore.com
 * @Title:  SchedulerListener.java   
 * @Package com.infore.dataacquisition.common.listener   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: deer
 * @date:   2018年7月3日 下午3:04:30   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2018 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
@Component
public class SchedulerListener implements ApplicationListener<ContextRefreshedEvent>{
	protected static final Logger logger = LoggerFactory.getLogger(SchedulerListener.class);

	@Autowired
	private SchedulerAllJobs schedulerAllJobs;
	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {
			logger.info("scheduler start begin....");
			schedulerAllJobs.scheduleJobs();
			logger.info("scheduler start end!");
		} catch(Exception e) {
			logger.error("scheduler start failed!",e);
			e.printStackTrace();
		}
	}

}
