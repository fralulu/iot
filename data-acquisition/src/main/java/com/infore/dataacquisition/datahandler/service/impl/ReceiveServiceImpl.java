package com.infore.dataacquisition.datahandler.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.infore.dataacquisition.common.utils.FinalModel;
import com.infore.dataacquisition.datahandler.mapper.FactorMapper;
import com.infore.dataacquisition.datahandler.mapper.StationMapper;
import com.infore.dataacquisition.datahandler.model.entity.Factor;
import com.infore.dataacquisition.datahandler.model.entity.Station;
import com.infore.dataacquisition.datahandler.service.IReceiveService;


/**
 * 
 * All rights Reserved, Designed By www.infore.com
 * @Title:  ReceiveServiceImpl.java   
 * @Package com.infore.dataacquisition.datahandler.service.impl   
 * @Description:   数据接收相关接口实现
 * @author: deer
 * @date:   2018年7月2日 上午10:37:00   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2018 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
@Service("receiveService")
public class ReceiveServiceImpl implements IReceiveService{
	@Resource
	private StationMapper stationDao;
	
	@Resource
	private FactorMapper factorDao;	
	
	
	//获取所有站点by number 
	@Override
	public Map<String, Station> getAllStation() {
		List<Station> stations=stationDao.selectAllStationsN();
		Map<String, Station> map=new HashMap<String, Station>();
		for (Station station : stations) {
			String key=station.getStationNumber();
			map.put(key, station);
		}
		return map;
	}
	
	//获取所有站点by ID
	@Override
	public Map<Integer, Station> getAllStationByID() {
		List<Station> stations=stationDao.selectAllStationsN();
		Map<Integer, Station> map=new HashMap<Integer, Station>();
		for (Station station : stations) {
			Integer key=station.getId();
			map.put(key, station);
		}
		return map;
	}
	
	//获取所有监测因子 byCODE
	@Override
	public Map<String, Factor> getAllProject() {
		// TODO Auto-generated method stub
		List<Factor> factors=factorDao.selectAllFactors();
		Map<String, Factor> map=new HashMap<String, Factor>();
		for (Factor factor : factors) {
			String key=factor.getFactorCode();
			map.put(key, factor);
			String oldkey=factor.getFactorCodeOld();
			if(factor.getFactorCodeOld()!=null){
				map.put(oldkey, factor);
			}
		}
		return map;
	}
	
	
	
	
	/**
	 * 初始化缓存数据
	 * @Title: getAllStationInstance   
	 * @Description: 获取所有站点   
	 * @param:       
	 * @return: void      
	 * @throws
	 */
	public synchronized void getAllStationInstance(){
		FinalModel.allStation= getAllStation();
    }
	
	//获取所有监测因子
	public synchronized void getAllProjectInstance(){		
		FinalModel.allProject= getAllProject();
	}
	

}
