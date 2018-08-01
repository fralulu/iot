/******************************************************************************
 * All Rights Reserved.
 * 本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.infore.dataacquisition.netty;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;

/**  
 * All rights Reserved, Designed By www.infore.com
 * @Title:  NettyServer.java   
 * @Package com.infore.dataacquisition.netty   
 * @Description:    NettyServer   
 * @author: deer
 * @date:   2018年6月28日 下午6:14:05   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2018 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
@Component
public class NettyServer {
	private static Logger logger = LoggerFactory.getLogger(NettyServer.class);
	
	@Value("${netty.receivePort}")
	private int tcpPort;
	
	@Autowired
	@Qualifier("serverBootstrap")
	private ServerBootstrap serverBootstrap;
	
	@Autowired
	@Qualifier("bossGroup")
	private EventLoopGroup bossGroup;
	
	@Autowired
	@Qualifier("workerGroup")
	private EventLoopGroup workerGroup;
	
	private ChannelFuture serverChannelFuture;
	

	/**
	 * @Title: start   
	 * @Description: 初始NettyServer时绑定端口，接收远程数据
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	public void start() throws Exception {
		System.out.println("nettyServer.bind 绑定端口"+tcpPort);
		logger.info("nettyServer.bind 绑定端口"+tcpPort);
		
		try {
			//绑定端口，同步等待成功
			 serverChannelFuture = serverBootstrap.bind(tcpPort).sync();
			
			//等待服务监听关闭端口
			serverChannelFuture.channel().closeFuture().sync();
			
			
		} catch (Exception e) {
			logger.error("nettyserver异常....",e);
			e.printStackTrace();
			
		}finally{
			//优雅退出，释放线程全部资源
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

	@PreDestroy
	public void stop() throws Exception {
	    //serverChannelFuture.channel().closeFuture().sync();
	    logger.info("关闭服务器....");
	  //优雅退出，释放线程全部资源
	    bossGroup.shutdownGracefully();
		workerGroup.shutdownGracefully();
	}
	
}
