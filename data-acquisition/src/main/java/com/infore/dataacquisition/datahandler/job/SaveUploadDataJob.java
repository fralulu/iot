/******************************************************************************
 * All Rights Reserved.
 * 本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.infore.dataacquisition.datahandler.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.infore.dataacquisition.datahandler.job.task.ITaskService;

/**  
 * All rights Reserved, Designed By www.infore.com
 * @Title:  SaveUploadDataJob.java   
 * @Package com.infore.dataacquisition.datahandler.job   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: deer
 * @date:   2018年7月3日 下午1:51:27   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2018 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
@DisallowConcurrentExecution
public class SaveUploadDataJob implements Job{
	
	private static Logger logger = LoggerFactory.getLogger(SaveUploadDataJob.class);
			
	@Autowired
	@Qualifier("SaveUploadDataTask")
	private ITaskService saveUploadDataThread;

	/* (non-Javadoc)
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		 logger.info("######schedule SaveUploadDataJob is running……");
		 saveUploadDataThread.saveData();
		 logger.info("######schedule SaveUploadDataJob  ended!");
	}

}
