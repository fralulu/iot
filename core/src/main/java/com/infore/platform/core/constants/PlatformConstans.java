/******************************************************************************
 * All Rights Reserved.
 * 本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.infore.platform.core.constants;

import com.infore.platform.core.common.constants.BaseConstants;

/**  
 * All rights Reserved, Designed By www.infore.com
 * @Title:  PlatformConstans.java   
 * @Package com.infore.platform.common.constants   
 * @Description:  应用平台常量
 * @author: Administrator  
 * @date:   2017年9月7日 下午6:27:37   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2017 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
public class PlatformConstans extends BaseConstants{
	
	/**
	 * 用户token
	 */
	public static final String USER_TOKEN = "token";
	
	/**
	 * 用户菜单
	 */
	public static final String USER_MENUS = "menus";
	
	/**
	 * 用户权限
	 */
	public static final String USER_PERMISSIONS = "permissions";

	/**
	 * token 认证参数
	 */
	public static final String HEAD_TOKEN_KEY = "Authorization";
	
	//--------------------------------------菜单常量
	public static final String  MENU_ID ="menuId";
	public static final String  MENU_NAME = "menuName";
	public static final String  MENU_KEY = "menuKey";
	public static final String  LINK_URL = "linkUrl";
	public static final String  ICON = "icon";
	public static final String  PERMISSION = "permission";
	
	//
	public static final String COMMON_CODE_CACHE = "commonCodeCache";

	/**
	 * 当前页码数(第几页)
	 */
	public static final String PAGE_INDEX = "pageIndex";

	/**
	 * 每页条数
	 */
	public static final String PAGE_SIZE = "pageSize";

	/**
	 * 排序字段及方法(DESC 降序,ASC 升序)
	 */
	public static final String ORDER_BY= "orderBy";
	
	/**
	 * 总条数
	 */
	public static final String TOTAL_COUNT = "totalCount";

	/**
	 * 列表数据
	 */
	public static final String LIST_DATA = "list";


	/**
	 * 创建人
	 */
	public static final String ID = "ID";

	/**
	 * 创建人
	 */
	public static final String CREATE_USER = "CREATE_USER";

	/**
	 * 创建时间
	 */
	public static final String CREATE_TIME = "CREATE_TIME";

	/**
	 * 修改人
	 */
	public static final String UPDATE_USER = "UPDATE_USER";

	/**
	 * 修改时间
	 */
	public static final String UPDATE_TIME = "UPDATE_TIME";

	/**
	 * 任务调度参数
	 */
	public static final String JOB_PARAM_KEY = "job_param";
	
}
