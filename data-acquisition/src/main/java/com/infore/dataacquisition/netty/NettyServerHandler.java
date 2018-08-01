package com.infore.dataacquisition.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandler.Sharable;

import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.infore.dataacquisition.common.utils.FinalModel;
import com.infore.dataacquisition.netty.thread.ParseDataThread;

@Component
@Qualifier("serverHandler")
@Sharable// 标志该Handler可以被多个Handler安全的共享。
public class NettyServerHandler extends ChannelHandlerAdapter{
	
	private static Logger logger = LoggerFactory.getLogger(NettyServerHandler.class);
	
	@Value("${netty.forwardIP}")
	private String forwardIP;
	
	@Value("${netty.forwardPort}")
	private int forwardPort;
	

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		try{
			String body=(String)msg;
			InetSocketAddress socketAddress = (InetSocketAddress) ctx.channel().remoteAddress();
			logger.info("netty服务端接收到"+socketAddress+"："+body.trim());
			String backcall="receive ok";
			ByteBuf resp=Unpooled.copiedBuffer(backcall.getBytes());
			ctx.write(resp);//ctx.writeAndFlush(resp); 相当于 ctx.write()  + channelReadComplete()方法
			if(FinalModel.forwordToEmmp){//用于数据转发
                Integer port = Integer.valueOf(forwardPort);
				Socket soc = new Socket(forwardIP,port);
				PrintWriter socketWriter = new PrintWriter(soc.getOutputStream());
				socketWriter.println(body);
				socketWriter.flush();
				Thread.sleep(10);
			}
			FinalModel.singleThreadExecutor.execute(new ParseDataThread(body,ctx));//解析报文
		}catch(Exception e){
			throw e;
		}
	}

	/**
	 * ctx.writeAndFlush(resp); 相当于 ctx.write()  + channelReadComplete()方法
	 */
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		ctx.close();
	}
	
	
	

}
