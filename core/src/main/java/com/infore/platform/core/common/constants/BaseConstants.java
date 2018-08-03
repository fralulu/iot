/******************************************************************************
 * All Rights Reserved.
 * 本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.infore.platform.core.common.constants;

/**  
 * All rights Reserved, Designed By www.infore.com
 * @Title:  BaseConstants.java   
 * @Package com.infore.platform.core.common.constants   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: Administrator  
 * @date:   2017年8月22日 上午8:45:12   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2017 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
public class BaseConstants {
	/**********************************************************************
     * 数据库标识
     **********************************************************************/
	public static final String DB_TYPE = "dbType";
	
	/**********************************************************************
     * 缓存启用标识
     **********************************************************************/
	public static final String CACHE_TYPE = "cacheType";
	/**
	 * jvm 缓存启用标识
	 */
	public static final String JVM_CACHE = "JVM_CACHE";
	
	/**
	 * redis 缓存启用标识
	 */
	
	public static final String REDIS_CACHE = "REDIS_CACHE";
	/**********************************************************************
     * 通知操作常用类型
     **********************************************************************/

    /**
     * 新增操作
     */
    public static final String NOTICE_ADD = "NOTICE_ADD";
    

    /**
     * 批量新增操作
     */
    public static final String NOTICE_ADD_LIST = "NOTICE_ADD_LIST";


    /**
     * 更新操作
     */
    public static final String NOTICE_UPDATE = "NOTICE_UPDATE";

    /**
     * 删除操作
     */
    public static final String NOTICE_DELETE = "NOTICE_DELETE";
    
    
	
	
}
