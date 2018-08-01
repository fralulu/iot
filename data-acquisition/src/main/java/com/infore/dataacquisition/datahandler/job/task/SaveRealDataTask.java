package com.infore.dataacquisition.datahandler.job.task;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.infore.dataacquisition.common.utils.FinalModel;
import com.infore.dataacquisition.common.utils.FormatUtil;
import com.infore.dataacquisition.datahandler.model.entity.DataReal;
import com.infore.dataacquisition.datahandler.model.entity.Factor;
import com.infore.dataacquisition.datahandler.model.entity.Station;
import com.infore.dataacquisition.datahandler.model.receive.UploadData;
import com.infore.dataacquisition.datahandler.model.receive.UploadValue;
import com.infore.dataacquisition.datahandler.service.IDataRealService;
import com.infore.dataacquisition.datahandler.service.IReceiveService;

/**
 *  运用于保存污染源与空气质量的实时数据
 * All rights Reserved, Designed By www.infore.com
 * @Title:  SaveRealDataThread.java   
 * @Package com.infore.dataacquisition.datahandler.job   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: deer
 * @date:   2018年7月3日 上午11:13:19   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2018 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
@Component
@Qualifier("SaveRealDataTask")
public class SaveRealDataTask implements ITaskService{
	private static Logger logger = LoggerFactory.getLogger(SaveRealDataTask.class);
	@Autowired
	private IReceiveService receiveService;
	
	@Autowired
	private IDataRealService dataRealService;
	
	/**
	 * 保存污染源实时数据
	 * @Title: savePolRealData
	 * @date 2016年5月20日 上午9:30:35
	 * @author  周文涛
	 */
	public void saveData(){
		try {
			Cache polrealdataCache = FinalModel.cacheManager.getCache("polrealdataCache");
			
			for (Object key : polrealdataCache.getKeys()) {
				
				logger.info("$$$$$$$$开始处理缓存polrealdataCache中key=["+key+"]的记录");
				
				Element ele=polrealdataCache.get(key);
				if(ele!=null){
					UploadData uploadData=(UploadData) ele.getValue();
					dealPol(uploadData);
					
				}				
				polrealdataCache.remove(key);//处理完毕后从缓存中删除
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}
	
	/**
	 * 更新污染源实时数据
	 * @Title: updatePol
	 * @date 2016年5月20日 上午9:38:30
	 * @author  周文涛
	 */
	private void dealPol(UploadData uploadData){
		try {
			Timestamp sendDatesql=Timestamp.valueOf(FormatUtil.getdateFormat(FormatUtil.SECOND_DATE_FORMAT, uploadData.getDataTime()));
			Timestamp receiveDatesql=Timestamp.valueOf(FormatUtil.getdateFormat(FormatUtil.SECOND_DATE_FORMAT, new Date()));
			Map<String,Station> allstations = FinalModel.allStation;
			Map<String,Factor> allfactors = FinalModel.allProject;
			//查询站点包含因子
			Station station=allstations.get(uploadData.getMN());	
			//重新加载一下
			if(station==null) {
				logger.info("站点MN号为："+uploadData.getMN()+" 缓存不存在,需要重新加载！");
				receiveService.getAllStationInstance();
				allstations = FinalModel.allStation;
				station=allstations.get(uploadData.getMN());
			}
			
			if(station!=null) {
				List<UploadValue> values=uploadData.getValues();
				List<DataReal> dataRealList = new ArrayList<>();
				
				DataReal dataReal = null;
				for (UploadValue uploadValue : values) {
					dataReal = new DataReal();
					Factor project=allfactors.get(uploadValue.getCode());
					if(project == null) {
						//重新加载一下
						logger.info("监测因子为："+uploadValue.getCode()+" 缓存不存在,需要重新加载！");
						receiveService.getAllProjectInstance();
						allfactors = FinalModel.allProject;
						project=allfactors.get(uploadValue.getCode());
					}
					if(project != null) {
						dataReal.setStationId(station.getId());
						dataReal.setFactorCode(project.getFactorCode());
						dataReal.setSendTime(sendDatesql);
						dataReal.setReceiveTime(receiveDatesql);
						dataReal.setValue(uploadValue.getRtd());
						dataReal.setFactorName(project.getFactorName());
						dataReal.setStationName(station.getStationName());
						dataReal.setEnterName(null);
						dataReal.setState(null);
						dataReal.setSign(null);
						dataRealList.add(dataReal);
					}else {
						logger.info("因子编码："+uploadValue.getCode()+"未配置");
					}
				}
				
				//查询分开是update还是insert（StationId、SendTime 查询）
				DataReal queryDataReal = new DataReal();
				queryDataReal.setStationId(station.getId());//站点编号
				queryDataReal.setSendTime(sendDatesql);//报文发送时间
				
				List<DataReal> oldDataReal = dataRealService.getParseDatas(queryDataReal);
				if(oldDataReal!=null && oldDataReal.size() > 0) {
					//批量更新
					dataRealService.batchUpdate(dataRealList);
				}else {
					//批量新增
					dataRealService.batchAdd(dataRealList);
				}
				
			} else {
				   logger.info("站点MN号为："+uploadData.getMN()+"未解析,数据库未配置");
			}
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}
	
}
