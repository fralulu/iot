package com.infore.dataacquisition.datahandler.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.infore.dataacquisition.datahandler.model.entity.DataReal;
import com.infore.platform.core.base.IBaseDao;

@SuppressWarnings("rawtypes")
public interface DataRealMapper extends IBaseDao {
    int deleteByPrimaryKey(@Param("stationId") Integer stationId, @Param("factorCode") Object factorCode);

    int insert(DataReal record);

    int insertSelective(DataReal record);

    DataReal selectByPrimaryKey(@Param("stationId") Integer stationId, @Param("factorCode") Object factorCode);

    int updateByPrimaryKeySelective(DataReal record);

    int updateByPrimaryKey(DataReal record);
    
    List<DataReal> selectListByEntity(DataReal record);
    
    void batchAddDataReal(List<DataReal> list);
    
    void batchUpdateDataReal(List<DataReal> list);
}