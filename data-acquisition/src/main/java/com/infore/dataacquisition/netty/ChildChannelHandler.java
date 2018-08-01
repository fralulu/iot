/******************************************************************************
 * All Rights Reserved.
 * 本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.infore.dataacquisition.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.channel.ChannelHandler.Sharable;  

/**  
 * All rights Reserved, Designed By www.infore.com
 * @Title:  ChildChannelHandler.java   
 * @Package com.infore.dataacquisition.netty   
 * @Description:    serverInitHandler 初始化netty使用的handler
 *                  用于配置各种编码解码器  
 * @author: deer
 * @date:   2018年6月28日 下午4:50:50   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2018 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
@Component
@Qualifier("childChannelHandler")
@Sharable// 标志该Handler可以被多个Handler安全的共享。
public class ChildChannelHandler extends ChannelInitializer<SocketChannel>{
	private static Logger logger = LoggerFactory.getLogger(ChildChannelHandler.class);
	

	@Value("${netty.decoderMaxLength}")
	private int maxLength;
	
	@Autowired
	@Qualifier("serverHandler")
	private NettyServerHandler nettyServerHandler;
	
	/**
	 * 212协议报文结构
	 * 包头                      字符类型                          length = 2         固定为##
	 * 数据段长度         十进制整数类型               length = 4         数据段的ASCII 字符数
	 * 数据段                  字符                                  0≤n≤1024                变长的数据（短信为140）
	 * CRC校验             十六进制整数                  length = 4
	 * 包尾                      字符                                  length = 2            固定为<CR><LF>（回车、换行）
	 * 
	 * 
	 */
	@Override
	protected void initChannel(SocketChannel sc) {
		System.out.println(sc.remoteAddress().getAddress().getHostAddress()+":"+sc.remoteAddress().getPort()+":nettyServer.childChannelHandler 启动数据接收");
		logger.info(sc.remoteAddress().getAddress().getHostAddress()+":"+sc.remoteAddress().getPort()+":nettyServer.childChannelHandler 启动数据接收");
		try{
			ChannelPipeline pipeline = sc.pipeline();
			//支持粘包处理，按照换行符处理，适用于212，不适用与水文(这段表示是按照行来读取的)
			pipeline.addLast(new LineBasedFrameDecoder(maxLength));
			pipeline.addLast(new StringDecoder());
			
			pipeline.addLast(nettyServerHandler);		
		}catch(Exception e){
			logger.error("初始化nettyserver异常:ChildChannelHandler-->",e);
			e.printStackTrace();
		}
	}

	
}
