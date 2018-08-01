package com.infore.dataacquisition.netty.thread;

import io.netty.channel.ChannelHandlerContext;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infore.dataacquisition.common.constant.Constants;
import com.infore.dataacquisition.common.utils.FinalModel;
import com.infore.dataacquisition.common.utils.FormatUtil;
import com.infore.dataacquisition.datahandler.model.receive.UploadData;
import com.infore.dataacquisition.datahandler.model.receive.UploadValue;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

/**
 * 
 * All rights Reserved, Designed By www.infore.com
 * @Title:  ParseDataThread.java   
 * @Package com.infore.dataacquisition.netty.thread   
 * @Description:    具体解码器
 *                       只适用于212-2011
 * @date:   2018年6月29日 上午11:30:31   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2018 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
public class ParseDataThread implements Runnable{	
	private static Logger logger = LoggerFactory.getLogger(ParseDataThread.class);
	private String msg;
	private ChannelHandlerContext ctx;
	public ParseDataThread(){
		
	}
	
	public ParseDataThread(String msg){
		this.msg=msg;
	}

	public ParseDataThread(String msg,ChannelHandlerContext ctx){
		this.msg=msg;
		this.ctx=ctx;
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public synchronized void run() {
		//比较字符串的规范性
		if(FinalModel.compareDataLength(msg)){
			String[] dataMsg=msg.substring(6, msg.length()-6).split("CP=&&");
			if(dataMsg.length<2){
				return ;
			}
			if(dataMsg[1].length()<23){
				return ;
			}
			//第一部分
			String head=dataMsg[0]+dataMsg[1].substring(0, 23);
			logger.info("消息头："+head);
			
			if(!head.contains("CN=2011;")) {
				logger.error("该报文非2011协议,确认报文中的CN项！");
				return;
			}
			
			UploadData uploadData=consistHead(head);
			String body=dataMsg[1].substring(24);
			List<UploadValue> values=consistBody(body);
			uploadData.setValues(values);
			//将解析的包文存入缓存
			Cache uploadCache = FinalModel.cacheManager.getCache("uploadCache");
			//String key=new String(uploadData.getST()+";"+uploadData.getCN()+";"+uploadData.getMN()+";"+uploadData.getDataTime());
			String key=new String(uploadData.getST()+";"+uploadData.getCN()+";"+uploadData.getMN()+";"+uploadData.getDataTime()+";"+uploadData.getQN());
			Element ele=new Element(key, uploadData);
			uploadCache.put(ele);
			//存入连接信息
			Map<String,ChannelHandlerContext> linkerctx=FinalModel.linkerctx;
			String mnkey=uploadData.getMN();
			if(linkerctx.get(mnkey)==null){
				linkerctx.put(mnkey, ctx);
			}else{
				linkerctx.remove(mnkey);
				linkerctx.put(mnkey, ctx);
			}
			//存入最新数据包
			Map<String,String> linkerData=FinalModel.linkerData;
			if(linkerData.get(mnkey)==null){
				linkerData.put(mnkey, FormatUtil.getdateFormat(FormatUtil.SECOND_DATE_FORMAT, new Date())+"F#G#X"+msg);
			}else{
				linkerData.remove(mnkey);
				linkerData.put(mnkey, FormatUtil.getdateFormat(FormatUtil.SECOND_DATE_FORMAT, new Date())+"F#G#X"+msg);
			}
			//过滤数据类型，存入实时数据缓存
			if((uploadData.getST().equals(Constants.T212_2005_ST_31)||uploadData.getST().equals(Constants.T212_2005_ST_32)
					|| uploadData.getST().equals(Constants.T212_2005_ST_21))
					&&uploadData.getCN().equals(Constants.T212_2005_CN_2011)){
				Cache polrealdataCache = FinalModel.cacheManager.getCache("polrealdataCache");
				//String keyreal=uploadData.getMN();
				String keyreal=uploadData.getMN()+uploadData.getQN();
				Element elereal=new Element(keyreal, uploadData);
				polrealdataCache.put(elereal);
			}else {
				logger.error("该报文ST非["+Constants.T212_2005_ST_31+","+Constants.T212_2005_ST_32+","+Constants.T212_2005_ST_21+"],不进行处理");
			}
		}
	}
	
	//解析数据头信息
	private static UploadData consistHead(String head){
		UploadData upload=new UploadData();
		String[] headArr=head.split(";");
		Class<? extends UploadData> cls=upload.getClass();
		for(int i=0;i<headArr.length;i++){
			String keyValue[]=headArr[i].split("=");
			String key=keyValue[0];
			String value=keyValue[1];
			try {//通过反射赋值
				Field field = cls.getDeclaredField(key);
				if (field != null) {
					Method fieldSetMet = cls.getMethod("set" + key, String.class);
					fieldSetMet.invoke(upload, value);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return upload;
	}
	
	//解析数据值信息
	private static List<UploadValue> consistBody(String body){
		List<UploadValue> values=new ArrayList<UploadValue>();
		String[] bodyArr=body.split(";");
		for(int i=0;i<bodyArr.length;i++){
			String[] elem=bodyArr[i].split(",");
			UploadValue uploadValue=new UploadValue();
			Class<? extends UploadValue> cls=uploadValue.getClass();
			for(int j=0;j<elem.length;j++){				
				String[] keyValue=elem[j].split("=");
				String headkey=keyValue[0];
				String value=keyValue[1];
				String[] headValue=headkey.split("-");
				String headcode=headValue[0];
				String headtype=headValue[1];
				uploadValue.setCode(headcode);
				try {
					Field field = cls.getDeclaredField(headtype);
					if (field != null) {
						Method fieldSetMet = cls.getMethod("set" + headtype,String.class);
						fieldSetMet.invoke(uploadValue, value);
					}
				}catch (Exception e) {
					e.printStackTrace();
				}				
			}
			values.add(uploadValue);
		}
		return values;
	}	

}
