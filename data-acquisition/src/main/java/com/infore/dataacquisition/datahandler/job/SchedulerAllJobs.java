/******************************************************************************
 * All Rights Reserved.
 * 本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.infore.dataacquisition.datahandler.job;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

/**  
 * All rights Reserved, Designed By www.infore.com
 * @Title:  SchedulerJobs.java   
 * @Package com.infore.dataacquisition.datahandler.job   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: deer
 * @date:   2018年7月3日 下午2:35:12   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2018 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
@Component
@EnableScheduling
public class SchedulerAllJobs {
	 @Autowired
	 @Qualifier("multitaskScheduler")
	 private SchedulerFactoryBean schedulerFactoryBean;
	 
	 @Autowired
	 @Qualifier("savePolRealDataJobDetail")
	 private JobDetail realDataJobDetail;
	 
	 @Autowired
	 @Qualifier("saveUploadDataJobDetail")
	 private JobDetail uploadDataJobDetail;
	 
	 @Autowired
	 @Qualifier("savePolRealDataJobTrigger")
	 private CronTrigger realDataJobTrigger;
	 
	 @Autowired
	 @Qualifier("saveUploadDataJobTrigger")
	 private CronTrigger uploadDataJobTrigger;
	 
	 
	/**
     * 该方法用来启动所有的定时任务
     * @throws SchedulerException
     */
    public void scheduleJobs() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        
        /**
         *  启动相关jogs
         */
        scheduleUploadDataJob(scheduler); //存储原始数据的job
        
        scheduleRealDataJob(scheduler); //存储实时数据的job
    }
    
    /**
     * 配置Job1
     * @param scheduler
     * @throws SchedulerException
     */
    private void scheduleRealDataJob(Scheduler scheduler) throws SchedulerException{
    	
        scheduler.scheduleJob(realDataJobDetail,realDataJobTrigger); 
    }
    
    /**
     * 配置Job
     * @param scheduler
     * @throws SchedulerException
     */
    private void scheduleUploadDataJob(Scheduler scheduler) throws SchedulerException{ 
        scheduler.scheduleJob(uploadDataJobDetail,uploadDataJobTrigger);
    }

	
}
