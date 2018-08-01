/******************************************************************************
 * All Rights Reserved.
 * 本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.infore.dataacquisition.service;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.infore.dataacquisition.common.utils.FinalModel;
import com.infore.dataacquisition.datahandler.model.entity.Factor;
import com.infore.dataacquisition.datahandler.model.entity.Station;
import com.infore.dataacquisition.datahandler.service.IReceiveService;

/**  
 * All rights Reserved, Designed By www.infore.com
 * @Title:  ReceiveDatasTest.java   
 * @Package com.infore.dataacquisition.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: deer
 * @date:   2018年7月2日 上午10:45:20   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2018 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
@RunWith(SpringJUnit4ClassRunner.class)  // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest
public class ReceiveDatasTest {
	
	@Autowired 
	private IReceiveService receive;
	
	@Test
	public void  testquery() {
		Map<String, Station> map = receive.getAllStation();
		System.out.println(map.toString());
		 Map<String,Factor> r = receive.getAllProject();
		 System.out.println(r.toString());
		
	}
	
	@Test
	public void testCache() {
		System.out.println("=======================");
		System.out.println(FinalModel.allProject);
	}
}
