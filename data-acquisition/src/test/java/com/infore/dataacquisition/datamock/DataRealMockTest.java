/******************************************************************************
 * All Rights Reserved.
 * 本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.infore.dataacquisition.datamock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.infore.dataacquisition.common.utils.FinalModel;
import com.infore.dataacquisition.datahandler.model.entity.Factor;
import com.infore.dataacquisition.datahandler.model.entity.Station;
import com.infore.dataacquisition.netty.thread.DataRealSimuThread;

/**  
 * All rights Reserved, Designed By www.infore.com
 * @Title:  DataRealMockTest.java   
 * @Package com.infore.dataacquisition.datamock   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: deer
 * @date:   2018年7月4日 上午9:28:31   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2018 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
@RunWith(SpringJUnit4ClassRunner.class)  // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest
public class DataRealMockTest {
		
	@Test
	public void test() {
		Map<String,Station> allstations = FinalModel.allStation;
		Map<String,Factor> allfactors = FinalModel.allProject;
		Station station=allstations.get("201512210001");	
		
		List<Factor> list = new ArrayList<>();
		allfactors.forEach((k,v) -> {
			if(!list.contains(v)) {
				list.add(v);
			}
		});
		
		System.out.println(list.toString());
		
//		Executors.newSingleThreadExecutor().execute(new DataRealSimuThread(station,list));
		try {
			Thread.sleep(1000*60*60*24);//一天
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
