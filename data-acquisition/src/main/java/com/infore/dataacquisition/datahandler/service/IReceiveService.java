package com.infore.dataacquisition.datahandler.service;


import java.util.Map;

import com.infore.dataacquisition.datahandler.model.entity.Factor;
import com.infore.dataacquisition.datahandler.model.entity.Station;

/**
 * 数据接收相关接口
 * @author 周文涛
 *
 *
 */
public interface IReceiveService {
	//获取所有监测因子以因子编码作为键值
	public Map<String,Factor> getAllProject();
	
	//获取所有监测因子以因子ID作为键值
	//public Map<Integer,Factor> getAllProjectByID();
	
	//获取所有站点by number
	public Map<String,Station> getAllStation();
	
	//获取所有站点by ID
	public Map<Integer,Station> getAllStationByID();
	
	//获取所有超标规律
	//public Map<Integer,OverproofSet> getAllOverproofSet();
	
	//获取站点对应监测因子
	//public List<Factor> getAllProjectByStationId(Integer stationId);
	
    public void getAllStationInstance();
	
	public void getAllProjectInstance();
	

}
