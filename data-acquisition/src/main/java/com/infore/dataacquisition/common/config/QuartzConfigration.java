package com.infore.dataacquisition.common.config;


import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.TriggerBuilder;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.infore.dataacquisition.datahandler.job.SaveRealDataJob;
import com.infore.dataacquisition.datahandler.job.SaveUploadDataJob;
import com.infore.dataacquisition.datahandler.job.SpringJobFactory;

/**
 * 
 * All rights Reserved, Designed By www.infore.com
 * @Title:  QuartzConfigration.java   
 * @Package com.infore.dataacquisition.common.config   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: deer
 * @date:   2018年7月3日 下午1:53:12   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2018 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
@Configuration
public class QuartzConfigration {
	
	 @Value("${scheduler.saveUploadDataCron}")
	 private String saveUploadDataCron;
	 
	 @Value("${scheduler.savePolRealDataCron}")
	 private String savePolRealDataCron;
	 
	 @Autowired
	 private SpringJobFactory springJobFactory;

    //多任务时的Scheduler，动态设置Trigger。一个SchedulerFactoryBean可能会有多个Trigger
    @Bean(name = "multitaskScheduler") 
    public SchedulerFactoryBean schedulerFactoryBean(){  
        SchedulerFactoryBean factory = new SchedulerFactoryBean(); 
        factory.setAutoStartup(true);
       // 用于quartz集群,QuartzScheduler 启动时更新己存在的Job
        factory.setOverwriteExistingJobs(true);
        // 延时启动(应用启动10 秒后)
        factory.setStartupDelay(5);
      //注意这里是重点
        factory.setJobFactory(springJobFactory); 
        return factory;   
    }
    
    @Bean(name = "savePolRealDataJobDetail") 
    public JobDetail savePolRealDataJobDetail() {
    	JobDetail job =  JobBuilder.newJob(SaveRealDataJob.class)
                                   .withIdentity("realDataJob", "group1").build(); 
    	return job;
    }
    

    @Bean(name = "savePolRealDataJobTrigger")  
    public CronTrigger cronSavePolRealDataJobTrigger() {  
    	CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(savePolRealDataCron); 
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
        		                 .withIdentity("realDataJobTrigger", "group1") 
        		                 .withSchedule(scheduleBuilder).build(); 
        return cronTrigger;

    }
    
    @Bean(name = "saveUploadDataJobDetail") 
    public JobDetail saveUploadDataJobDetail() {
    	JobDetail job =  JobBuilder.newJob(SaveUploadDataJob.class)
                                   .withIdentity("uploadDataJob", "group1").build(); 
    	return job;
    }
    
    @Bean(name = "saveUploadDataJobTrigger")  
    public CronTrigger cronSaveUploadDataJobTrigger() {  
    	CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(saveUploadDataCron); 
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
        		                 .withIdentity("uploadDataJobTrigger", "group1") 
        		                 .withSchedule(scheduleBuilder).build(); 
        return cronTrigger;

    }
    
    /*
     * quartz初始化监听器
     */
    @Bean
    public QuartzInitializerListener executorListener() {
       return new QuartzInitializerListener();
    }

    
}