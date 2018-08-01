/******************************************************************************
 * All Rights Reserved.
 * 本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.infore.dataacquisition.common.listener;

import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.infore.dataacquisition.netty.NettyServer;
import com.infore.dataacquisition.netty.thread.NettyStartThread;

/**  
 * All rights Reserved, Designed By www.infore.com
 * @Title:  NettyServerInitListener.java   
 * @Package com.infore.dataacquisition.listener   
 * @Description:    该类用于webserver启动完毕后，调用线程启动netty
 *                     
 * @author: deer
 * @date:   2018年6月29日 上午8:43:47   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2018 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
@Component
public class NettyServerInitListener implements ApplicationListener<ContextRefreshedEvent>{
	 protected static final Logger logger = LoggerFactory.getLogger(NettyServerInitListener.class);
	 

		@Autowired
		private NettyServer nettyServer;

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		logger.info("web started,nettyserver init......");
		
		Executors.newSingleThreadExecutor().execute(new NettyStartThread(nettyServer));
	}

}
