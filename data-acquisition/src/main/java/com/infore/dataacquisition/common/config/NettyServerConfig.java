/******************************************************************************
 * All Rights Reserved.
 * 本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.infore.dataacquisition.common.config;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.infore.dataacquisition.netty.ChildChannelHandler;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**  
 * All rights Reserved, Designed By www.infore.com
 * @Title:  NettyConfig.java   
 * @Package com.infore.dataacquisition.config   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: deer
 * @date:   2018年6月28日 下午4:03:16   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2018 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
@Configuration
public class NettyServerConfig {
		
	@Value("${netty.receivePort}")
	private int tcpPort;
	
	
	@Autowired
	@Qualifier("childChannelHandler")
	private ChildChannelHandler childChannelHandler;
	
   
	@Bean(name = "serverBootstrap")
	public ServerBootstrap bootstrap() {
		ServerBootstrap b = new ServerBootstrap();
		b.group(bossGroup(), workerGroup())
				.channel(NioServerSocketChannel.class)
				.childHandler(childChannelHandler)
		        .option(ChannelOption.SO_BACKLOG, 10240)
		        // 保持连接
                .option(ChannelOption.SO_KEEPALIVE, true);
		return b;
	}

	
	@Bean(name = "bossGroup", destroyMethod = "shutdownGracefully")
	public EventLoopGroup bossGroup() {
		return new NioEventLoopGroup();
	}

	@Bean(name = "workerGroup", destroyMethod = "shutdownGracefully")
	public EventLoopGroup workerGroup() {
		return new NioEventLoopGroup();
	}

	@Bean(name = "tcpSocketAddress")
	public InetSocketAddress tcpPort() {
		return new InetSocketAddress(tcpPort);
	}

	
}
