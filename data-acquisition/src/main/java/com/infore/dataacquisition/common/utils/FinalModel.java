package com.infore.dataacquisition.common.utils;



import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import com.infore.dataacquisition.datahandler.model.entity.Factor;
import com.infore.dataacquisition.datahandler.model.entity.OverproofSet;
import com.infore.dataacquisition.datahandler.model.entity.Station;

import net.sf.ehcache.CacheManager;
 

public class FinalModel {
	//验证数据格式
	public static final Pattern VALID_PATTERN = Pattern.compile("##\\d{4}.*CP=&&.*&&\\w{4}");
	//线程单例模式
	public static ExecutorService  singleThreadExecutor = new ThreadPoolExecutor(1, 1,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
	//public static ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
	//线程无限
	public static ExecutorService cachedThreadPool = new ThreadPoolExecutor( 0,Integer.MAX_VALUE,60L,TimeUnit.SECONDS,new SynchronousQueue<Runnable>());;
	//public static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
	//获取缓存
	public static CacheManager  cacheManager = CacheManager.getInstance();
	//获取所有站点
	public static Map<String,Station> allStation=null;	
	public static Map<Integer,Station> allIdStation=null;	
	//获取所有监测因子
	public static Map<String,Factor> allProject=null;
	public static Map<Integer,Factor> allIdProject=null;
	//因子数据状态限值
	public static Map<Integer,OverproofSet> allOverproofSet = null;
	//连接通道信息
	public static Map<String,ChannelHandlerContext> linkerctx=new HashMap<String, ChannelHandlerContext>();
	//最新数据信息
	public static Map<String,String> linkerData=new HashMap<String,String>();
	
	
	//单位吨
	public static final String WASTEEMISSTION_UNIT="kg";
	
	//单位升
	public static final String WASTEWATER_UNIT="L";
	
	//站点在线
	public static final Integer STATION_ONLINE=1;
	//站点离线
	public static final Integer STATION_OFFLINE=0;
	//是否进行数据转发
	public static boolean forwordToEmmp = false;
	
	
	/*@Resource
	private IReceiveService receiveService;
	
	public FinalModel(){
		receiveService=(IReceiveService) SpringUtil.getBean("receiveService");
	}
	
	//获取所有监测因子	
	public synchronized Map<String,Factor> getAllProjectInstance(){		
		if(allProject==null||allProject.size()==0){
			allProject= receiveService.getAllProject();
		}
		return allProject;
	}
		
	//获取所有监测因子	
	public synchronized Map<Integer,Factor> getAllProjectInstanceById(){		
		if(allIdProject==null||allIdProject.size()==0){
			allIdProject= receiveService.getAllProjectByID();	
		}
		return allIdProject;
	}
	
	//获取所有站点对应监测因子
	public List<Factor> getProjectInstanceByStationId(Integer stationId){
		return receiveService.getAllProjectByStationId(stationId);
	}
	
	//获取所有站点
	public synchronized Map<String,Station> getAllStationInstance(){
		if(allStation==null||allStation.size()==0){
			allStation=receiveService.getAllStation();
		}
		return allStation;
	}
	//通过站点ID获取站点
	public synchronized Map<Integer,Station> getAllStationInstanceById(){
		if(allIdStation==null||allIdStation.size()==0){
			allIdStation=receiveService.getAllStationByID();	
		}
		return allIdStation;
	}
	
	//获取所有超标规则
	public synchronized Map<Integer,OverproofSet> getAllOverProofSet(){
		if(allOverproofSet==null||allOverproofSet.size()==0){
			allOverproofSet=receiveService.getAllOverproofSet();
		}
		return allOverproofSet;
	}*/
	
	//正则表达式验证
	public static String compareDataModel(String msg){
		Matcher dataTimeMatcher = FinalModel.VALID_PATTERN.matcher(msg);
		if(dataTimeMatcher.find()){
			return dataTimeMatcher.group();
		}
		return "ERROR";
	}
	
	//字符串长度验证
	public synchronized static boolean compareDataLength(String msg){
		String checkMsg=FinalModel.compareDataModel(msg);
		if(!"ERROR".equals(checkMsg)){
			int msglength=checkMsg.length();
			String headLenth=checkMsg.substring(2,6);
			String dataStr=checkMsg.substring(6, msglength-4);
			int needlenth=Integer.parseInt(headLenth);
			int reallenth=dataStr.length();
			if(needlenth==reallenth){
				return true;
			}else{
				return false;
			}		
		}else{
			return false;
		}
			
	}
	
	//清空缓存数据
	public static void refreshCache(){
		allIdProject=null;
		allIdStation=null;
		allOverproofSet=null;
		allProject=null;
		allStation=null;
	}
	
	public static void main(String[] args) {
		String aa="##0200ST=32;CN=2011;PW=123456;MN=20141030003;CP=&&DataTime=20171222113000;001-Rtd=7.220,001-Flag=N;B01-Rtd=3.291,B01-Flag=N;B00-Rtd=96213.000,B00-Flag=N;060-Rtd=13.690,060-Flag=N;011-Rtd=11.291,011-Flag=N&&C301";
		System.out.println(compareDataLength(aa));
	}
}
