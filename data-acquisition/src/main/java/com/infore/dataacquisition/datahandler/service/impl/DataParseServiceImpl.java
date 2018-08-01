/******************************************************************************
 * All Rights Reserved.
 * 本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.infore.dataacquisition.datahandler.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infore.dataacquisition.datahandler.mapper.DataParseMapper;
import com.infore.dataacquisition.datahandler.model.entity.DataParse;
import com.infore.dataacquisition.datahandler.service.IDataParseService;

/**  
 * All rights Reserved, Designed By www.infore.com
 * @Title:  DataParseServiceImpl.java   
 * @Package com.infore.dataacquisition.datahandler.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: deer
 * @date:   2018年7月2日 下午5:07:55   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2018 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
@Service
public class DataParseServiceImpl implements IDataParseService{
	
	@Autowired
	private DataParseMapper dataParseMapper;
	
	//根据stationId、sendTime查询
	public List<DataParse> getParseDatas(DataParse dataParse){
		return this.dataParseMapper.selectListByEntity(dataParse);
	}

	@Transactional
	@Override
	public void batchAdd(List<DataParse> dataParse) {
		dataParseMapper.batchAddDataParse(dataParse);
	}

	@Transactional
	@Override
	public void batchUpdate(List<DataParse> dataParse) {
		dataParseMapper.batchUpdateDataParse(dataParse);
	}
}
