package com.infore.dataacquisition.datahandler.mapper;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.infore.dataacquisition.datahandler.model.entity.DataParse;
import com.infore.platform.core.base.IBaseDao;

public interface DataParseMapper extends IBaseDao {
    int deleteByPrimaryKey(@Param("stationId") Integer stationId, @Param("factorCode") Object factorCode, @Param("sendTime") Date sendTime);

    int insert(DataParse record);

    int insertSelective(DataParse record);

    DataParse selectByPrimaryKey(@Param("stationId") Integer stationId, @Param("factorCode") Object factorCode, @Param("sendTime") Date sendTime);

    int updateByPrimaryKeySelective(DataParse record);

    int updateByPrimaryKey(DataParse record);
    
    List<DataParse> selectListByEntity(DataParse record);
    
    void batchAddDataParse(List<DataParse> list);
    
    void batchUpdateDataParse(List<DataParse> list);
}