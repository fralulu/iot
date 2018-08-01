/******************************************************************************
 * All Rights Reserved.
 * 本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.infore.dataacquisition.netty.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.infore.dataacquisition.netty.NettyServer;

/**  
 * All rights Reserved, Designed By www.infore.com
 * @Title:  NettyInitThread.java   
 * @Package com.infore.dataacquisition.netty.thread   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: deer
 * @date:   2018年6月29日 上午8:48:03   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2018 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
public class NettyStartThread  implements Runnable{
	 protected static final Logger logger = LoggerFactory.getLogger(NettyStartThread.class);
	
	@Autowired
	private NettyServer nettyServer;
	
	public NettyStartThread() {}
	
	public NettyStartThread(NettyServer nettyServer) {
		this.nettyServer =  nettyServer;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 * 
	 */
	@Override
	public synchronized void run() {
		try {
			Thread.sleep(2000);//暂停2秒启动
			nettyServer.start();
		} catch (Exception e) {
			logger.error("netty server started faild!",e);
			e.printStackTrace();
		}
		
	}

}
