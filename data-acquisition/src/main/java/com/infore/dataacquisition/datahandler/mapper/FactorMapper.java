package com.infore.dataacquisition.datahandler.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.infore.dataacquisition.datahandler.model.entity.Factor;
import com.infore.platform.core.base.IBaseDao;

@SuppressWarnings("rawtypes")
public interface FactorMapper extends IBaseDao{
    int deleteByPrimaryKey(Integer id);

    int insert(Factor record);

    int insertSelective(Factor record);

    Factor selectByPrimaryKey(Integer id);
    
//    List<Factor> selectByStationKeys(@Param("ids") String ids);

    int updateByPrimaryKeySelective(Factor record);

    int updateByPrimaryKey(Factor record);
    /**
     * 返回因子的基本信息 id factorName
     * @return
     */
    List<Map<String,Object>> selectAllFactorsBasicInfo();
    /**
     * 获取所有因子的详细信息
     * selectAllFactors
     * @author 蒋恒涛
     * @return List<Factor>
     * @date 2017年7月24日 上午10:32:57
     */
	List<Factor> selectAllFactors();
	/**
	 * code查factor
	 * selectByFactorCode
	 * @author 蒋恒涛
	 * @param code 
	 * @return Factor
	 * @date 2017年7月24日 下午1:59:40
	 */
	Factor selectByFactorCode(String code);
	/**
	 * 删除记录
	 * delByIds
	 * @author 蒋恒涛
	 * @return int
	 * @param ids
	 * @date 2017年7月24日 下午3:05:36
	 */
	int delByIds(@Param("ids")String ids);
	/**
	 * 关键字搜索
	 * searchByKey
	 * @author 蒋恒涛
	 * @return List<Factor>
	 * @param key
	 * @date 2017年7月24日 下午3:13:39
	 */
	List<Factor> searchByKey(@Param("key")String key);
	/**
	 * 根据站点ID查询站点监测的因子
	 * @author 蒋恒涛
	 * @return List<Factor>
	 * @param stationId
	 * @return
	 * @date 2017年7月25日下午1:48:53
	 */
	//List<Factor> selectByStationId(Integer stationId);
	/**
	 * 根据企业ID获取监测因子
	 * @author 蒋恒涛
	 * @return List<Factor>
	 * @param id
	 * @date 2017年7月28日上午10:50:48
	 */
	//List<Factor> selectByEnterId(Integer id);
	/**
	 * 查询污染因子的基本信息
	 * @author 蒋恒涛
	 * @return List<Map<String,Object>>
	 * @date 2017年8月1日上午11:16:22
	 */
	List<Map<String, Object>> selectPolluFactors();
   
	/**
	 * 查询站点污染源因子
	 * @Date 2017年7月29日 下午1:27:41
	 * @Author renyu
	 * @return
	 */
//	List<Factor> selectStationPollutionFactors(@Param("stationId")Integer stationId);
    
	/**
	 * 查询污染源因子
	 * @Date 2017年8月1日 上午11:11:34
	 * @Author renyu
	 * @param stationId
	 * @return
	 */
	//List<Factor> selectPollutionFactors();
}