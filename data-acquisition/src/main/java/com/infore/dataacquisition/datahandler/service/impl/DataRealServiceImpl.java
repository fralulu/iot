/******************************************************************************
 * All Rights Reserved.
 * 本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.infore.dataacquisition.datahandler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infore.dataacquisition.datahandler.mapper.DataRealMapper;
import com.infore.dataacquisition.datahandler.model.entity.DataReal;
import com.infore.dataacquisition.datahandler.service.IDataRealService;

/**  
 * All rights Reserved, Designed By www.infore.com
 * @Title:  DataRealServiceImpl.java   
 * @Package com.infore.dataacquisition.datahandler.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: deer
 * @date:   2018年7月3日 上午10:26:06   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2018 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
@Service
public class DataRealServiceImpl implements IDataRealService{
	
	@Autowired
	private DataRealMapper dataRealMapper;

	//根据stationId、sendTime查询
	@Override
	public List<DataReal> getParseDatas(DataReal dataReal) {
		return dataRealMapper.selectListByEntity(dataReal);
	}

	@Transactional
	@Override
	public void batchAdd(List<DataReal> dataRealList) {
		dataRealMapper.batchAddDataReal(dataRealList);
	}

	@Transactional
	@Override
	public void batchUpdate(List<DataReal> dataRealList) {
		dataRealMapper.batchUpdateDataReal(dataRealList);
	}

}
