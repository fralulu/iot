package com.infore.platform.core.base;

import com.infore.platform.core.common.constants.BaseConstants;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@SuppressWarnings("hiding")
public interface IBaseDao<T>{

    String dbType = getDbType();

    static String getDbType() {
        if (dbType != null) {
            return dbType;
        }
        YamlMapFactoryBean factory = new YamlMapFactoryBean();
        factory.setResources(new ClassPathResource[] {new ClassPathResource("application.yml")});
        Map<String, Object> root = factory.getObject();
        if (root == null) {
            return null;
        }
        Map<String, Object> secrets = root.keySet().stream().collect(Collectors.toMap(k -> k, root::get));
        return (String) secrets.get(BaseConstants.DB_TYPE);
    }

    /**
	 * 根据ID删除记录
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(String id) throws Exception;

    /**
     * 插入记录
     * @param record
     * @return
     */
	<T> int insert(T record) throws Exception;

    /**
     * 批量添加记录
     * @param list
     * @return
     */
    <T>  int batchInsert(List<Map<String, Object>> list) throws Exception;

    /**
     * 根据主键查询记录
     * @param id
     * @return
     */
    Map<String, Object> selectByPrimaryKey(Object id) throws Exception;
    
    /**
     * 修改记录
     * @param record
     * @return
     */
    <T>  int updateByPrimaryKey(T record) throws Exception;

    /**
     * 修改所以业务字段
     * @param record
     * @return
     */
    <T>  int updateAllColumnByPrimaryKey(T record) throws Exception;
	
	/**
	 * 分页查询
	 * @param parasMap
	 * @return
     */
    <T> List<T> selectListByPagination(Map<String, Object> parasMap) throws Exception;
    
    /**
     * 查询条数
     * @param parasMap
     * @param <T>
     * @return
     */
    <T> int queryCount(Map<String, Object> parasMap) throws Exception;
}
