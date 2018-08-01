/******************************************************************************
 * All Rights Reserved.
 * 本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.infore.dataacquisition.datahandler.service;

import java.util.List;

import com.infore.dataacquisition.datahandler.model.entity.DataReal;

/**  
 * All rights Reserved, Designed By www.infore.com
 * @Title:  IDataRealService.java   
 * @Package com.infore.dataacquisition.datahandler.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: deer
 * @date:   2018年7月3日 上午10:24:36   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2018 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
public interface IDataRealService {
	
   public List<DataReal> getParseDatas(DataReal dataReal);
	
	public void batchAdd(List<DataReal> dataRealList);
	
	public void batchUpdate(List<DataReal> dataRealList);
}
