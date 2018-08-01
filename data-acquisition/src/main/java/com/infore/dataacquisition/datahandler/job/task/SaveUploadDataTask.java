package com.infore.dataacquisition.datahandler.job.task;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.infore.dataacquisition.common.constant.Constants;
import com.infore.dataacquisition.common.utils.FinalModel;
import com.infore.dataacquisition.common.utils.FormatUtil;
import com.infore.dataacquisition.datahandler.model.entity.DataParse;
import com.infore.dataacquisition.datahandler.model.entity.Factor;
import com.infore.dataacquisition.datahandler.model.entity.Station;
import com.infore.dataacquisition.datahandler.model.receive.UploadData;
import com.infore.dataacquisition.datahandler.model.receive.UploadValue;
import com.infore.dataacquisition.datahandler.service.IDataParseService;
import com.infore.dataacquisition.datahandler.service.IReceiveService;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

/**
 * 运用于保存各种上传数据，包括污染源与空气站的实时数据，历史数据等
 * All rights Reserved, Designed By www.infore.com
 * @Title:  SaveUploadDataThread.java   
 * @Package com.infore.dataacquisition.datahandler.job   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: deer
 * @date:   2018年7月2日 下午10:23:52   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2018 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
@Component
@Qualifier("SaveUploadDataTask")
public class SaveUploadDataTask implements ITaskService{	
	private static Logger logger = LoggerFactory.getLogger(SaveUploadDataTask.class);
	
	@Autowired
	private IReceiveService receiveService;
	@Autowired
	private IDataParseService dataParseService;
	
	/**
	 * 保存上传数据
	 * @Title: saveUploadData
	 * @Description: TODO
	 * @date 2016年5月20日 上午9:27:26
	 * @author  周文涛
	 */
	public void saveData(){
		try {
			Cache uploadCache = FinalModel.cacheManager.getCache("uploadCache");
			for (Object key : uploadCache.getKeys()) {
				
				String[] keys=key.toString().split(";");
				String ST=keys[0];
				String CN=keys[1];
				Element ele=uploadCache.get(key);
				logger.info("$$$$$$$$开始处理缓存uploadCache中key=["+key+"]的记录");
				if(ele!=null){
					UploadData uploadData=(UploadData) ele.getValue();
					//大气环境污染
					if(ST.equals(Constants.T212_2005_ST_31)){
						savePollutant(CN, uploadData);
					}
					//地表水体环境污染
					else if(ST.equals(Constants.T212_2005_ST_32)){
						savePollutant(CN, uploadData);
					}
					//空气质量监测
					else if(ST.equals(Constants.T212_2005_ST_22)){
						
					}
					//地表水监测
					else if(ST.equals(Constants.T212_2005_ST_21)){
						savePollutant(CN, uploadData);
					}
				}				
			    uploadCache.remove(key);
			}
		} catch (Exception e) {
			logger.error("saveUploadData error:",e);
		}
	}
	
	
	/**
	 * 保存污染源上传数据
	 * @Title: savePollutant
	 * @Description: TODO
	 * @date 2016年5月20日 上午9:27:05
	 * @author  周文涛
	 */
	private void savePollutant(String CN,UploadData uploadData){
		//实时数据
		if(CN.equals(Constants.T212_2005_CN_2011)){
			savePollutant2011(uploadData);
		}
		//小时数据
		else if(CN.equals("2061")){
			
		}
		//分钟数据
		else if(CN.equals("2051")){
			
		}				
		//小时数据
		else if(CN.equals("2031")){
			
		}
	}
	
	/**
	 * 保存污染源实时上传数据
	 * @Title: savePollutant2011
	 * @Description: TODO
	 * @date 2016年5月20日 上午9:22:47
	 * @author  周文涛
	 */
	@SuppressWarnings({ "static-access", "unused" })
	private void savePollutant2011(UploadData uploadData){
		try {
			Map<String,Station> allstations=new FinalModel().allStation;
			Map<String,Factor> allfactors=new FinalModel().allProject;
			Timestamp sendDatesql=Timestamp.valueOf(FormatUtil.getdateFormat(FormatUtil.SECOND_DATE_FORMAT, uploadData.getDataTime()));
			Timestamp receiveDatesql=Timestamp.valueOf(FormatUtil.getdateFormat(FormatUtil.SECOND_DATE_FORMAT, new Date()));
			Station station=allstations.get(uploadData.getMN());
			//重新加载一下
			if(station==null) {
				logger.info("站点MN号为："+uploadData.getMN()+" 缓存不存在,需要重新加载！");
				receiveService.getAllStationInstance();
				allstations=new FinalModel().allStation;
				station=allstations.get(uploadData.getMN());
			}
			if(station!=null){
				List<UploadValue> values=uploadData.getValues();
				List<DataParse>   dataParseNeedList = new ArrayList<>();
				DataParse  dataParse = null;
				for (UploadValue uploadValue : values) {
					dataParse = new DataParse();
					Factor project=allfactors.get(uploadValue.getCode());
					if(project == null) {
						//重新加载一下
						logger.info("监测因子为："+uploadValue.getCode()+" 缓存不存在,需要重新加载！");
						receiveService.getAllProjectInstance();
						allfactors=new FinalModel().allProject;
						project=allfactors.get(uploadValue.getCode());
					}
					
					if(project != null) {
						Double rtd=uploadValue.getRtd();
						dataParse.setStationId(station.getId());
						dataParse.setFactorCode(project.getFactorCode());
						dataParse.setSendTime(sendDatesql);
						dataParse.setStationName(station.getStationName());
						dataParse.setEnterName(null);
						dataParse.setFactorName(project.getFactorName());
						dataParse.setReceiveTime(receiveDatesql);
						dataParse.setValue(uploadValue.getRtd());
						dataParse.setState(null);
						dataParse.setSign(null);
						dataParseNeedList.add(dataParse);
					}else {
						logger.info("因子编码："+uploadValue.getCode()+"未配置");
					}
				}
				
				//查询分开是update还是insert（StationId、SendTime 查询）
				DataParse queryDataParse = new DataParse();
				queryDataParse.setStationId(station.getId());//站点编号
				queryDataParse.setSendTime(sendDatesql);//报文发送时间
				
				List<DataParse> oldParse = dataParseService.getParseDatas(queryDataParse);
				if(oldParse!=null && oldParse.size() > 0) {
					//批量更新
					dataParseService.batchUpdate(dataParseNeedList);
				}else {
					//批量新增
					dataParseService.batchAdd(dataParseNeedList);
				}
				
			}else {
				 logger.info("站点MN号为："+uploadData.getMN()+"未解析,数据库未配置");
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}	
	}
		
	/**
	 * 保存空气质量数据，留待以后需要再开发
	 * @Title: saveAir
	 * @Description: TODO
	 * @date 2016年5月20日 上午9:26:24
	 * @author  周文涛
	 */
	private void saveAir(String CN,UploadData uploadData){
		//实时数据
		if(CN.equals("2011")){
			
		}
		//小时数据
		else if(CN.equals("2061")){
			
		}
		//分钟数据
		else if(CN.equals("2051")){
			
		}				
		//小时数据
		else if(CN.equals("2031")){
			
		}
	}
	
}
