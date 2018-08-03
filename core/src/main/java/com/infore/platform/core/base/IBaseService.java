package com.infore.platform.core.base;

import com.infore.platform.core.exception.ServerRuntimeException;

import java.util.Map;

public interface IBaseService {

    /**
     * 根据ID删除记录
     *
     * @param id 主键
     * @return 影响行数
     */
    Response deleteByPrimaryKey(String id) throws ServerRuntimeException;

    /**
     * 插入记录
     * @param record 记录
     * @return 影响行数
     */
    Response insert(Map<String, Object> record) throws ServerRuntimeException;

    /**
     * 根据主键查询记录
     * @param id 主键
     * @return map
     */
    Response selectByPrimaryKey(String id) throws ServerRuntimeException;

    /**
     * 修改记录
     * @param record 记录
     * @return 影响行数
     */
    Response updateByPrimaryKey(Map<String, Object> record) throws ServerRuntimeException;

    /**
     * 修改所有业务字段
     * @param record 记录
     * @return resp
     */
    Response updateAllColumnByPrimaryKey(Map<String, Object> record) throws ServerRuntimeException;

    /**
     * 分页查询
     * @param parasMap 查询条件
     * @return list
     */
    Response selectListByPagination(Map<String, Object> parasMap) throws ServerRuntimeException;

    /**
     * 查询条数
     * @param parasMap 条件
     * @return 条数
     */
    int queryCount(Map<String, Object> parasMap) throws ServerRuntimeException;
}
