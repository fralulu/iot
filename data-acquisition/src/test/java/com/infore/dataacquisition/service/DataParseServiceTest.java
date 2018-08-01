/******************************************************************************
 * All Rights Reserved.
 * 本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.infore.dataacquisition.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.infore.dataacquisition.common.utils.DateUtil;
import com.infore.dataacquisition.datahandler.model.entity.DataParse;
import com.infore.dataacquisition.datahandler.service.IDataParseService;

/**  
 * All rights Reserved, Designed By www.infore.com
 * @Title:  DataParseServiceTest.java   
 * @Package com.infore.dataacquisition.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: deer
 * @date:   2018年7月2日 下午10:34:36   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2018 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
@RunWith(SpringJUnit4ClassRunner.class)  // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest
public class DataParseServiceTest {
	
	@Autowired
	private IDataParseService dataParseService;
	
	@Test
	public void testUpdate() {
		List<DataParse> list = new ArrayList<>();
		DataParse data = new DataParse();
		data.setEnterName("xxxxxttttt");
		data.setFactorCode("ph");
		data.setFactorName("PH值t");
		data.setReceiveTime(new Date());
		data.setSendTime(DateUtil.StringTodate("2018-07-02 23:02:02", "yyyy-MM-dd HH:mm:ss"));
		data.setStationId(1);
		data.setStationName("测试站点t");
		data.setValue(1.3);
		list.add(data);
		data = new DataParse();
		data.setEnterName("wwwwtt");
		data.setFactorCode("phx");
		data.setFactorName("PH值xt");
		data.setReceiveTime(new Date());
		data.setSendTime(DateUtil.StringTodate("2018-07-02 23:02:02", "yyyy-MM-dd HH:mm:ss"));
		data.setStationId(1);
		data.setStationName("测试站点x");
		data.setValue(1.6);
		list.add(data);
		
		dataParseService.batchUpdate(list);
	}
	
	@Test
	public void testadd() {
		List<DataParse> list = new ArrayList<>();
		DataParse data = new DataParse();
		data.setEnterName("xxxxxxxx");
		data.setFactorCode("ph");
		data.setFactorName("PH值");
		data.setReceiveTime(new Date());
		data.setSendTime(new Date());
		data.setStationId(1);
		data.setStationName("测试站点");
		data.setValue(1.1);
		data.setSendTime(new Date());
		list.add(data);
		data = new DataParse();
		data.setEnterName("wwww");
		data.setFactorCode("phx");
		data.setFactorName("PH值x");
		data.setReceiveTime(new Date());
		data.setSendTime(new Date());
		data.setStationId(1);
		data.setStationName("测试站点x");
		data.setValue(1.2);
		data.setSendTime(new Date());
		list.add(data);
		
		
		dataParseService.batchAdd(list);
	}
}
