package com.infore.dataacquisition.datahandler.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.infore.dataacquisition.datahandler.model.entity.Station;
import com.infore.platform.core.base.IBaseDao;

@SuppressWarnings("rawtypes")
public interface StationMapper extends IBaseDao{
    int deleteByPrimaryKey(Integer id);

    int insert(Station record);

    int insertSelective(Station record);

    Station selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Station record);

    int updateByPrimaryKey(Station record);
    //获取指定ID的站点
    List<Station> selectByStationIds(@Param(value="ids")String ids);
    //根据地区id查询站点
	List<Station> selectByAdmIds(@Param(value="ids")String admIds);
	//根据角色ID查询所有站点
	List<Station> selectAllStations();
	//查询所有站点
	List<Station> selectAllStationsN();
/*	//站点因子中间表插入数据
	int insertStationFactor(Integer stationId, Integer factorId);
	//删除中间表信息
	int deleteStationFactorByStationId(Integer id);

	int deleteStationFactorByStationIds(@Param("ids")String ids);
	//删除站点
	int deleteByPrimaryKeys(@Param("ids")String ids);
	//改角色下监测某因子的所有站点
	List<Station> selectAllStationsByFactorRole(Integer roleId, Integer factorId);*/
	
}