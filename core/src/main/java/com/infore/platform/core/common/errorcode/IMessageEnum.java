/******************************************************************************
 * All Rights Reserved.
 * 本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.infore.platform.core.common.errorcode;

/**  
 * All rights Reserved, Designed By www.infore.com
 * @Title:  IMessageEnum.java   
 * @Package com.infore.platform.core.common.errorcode   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: Administrator  
 * @date:   2017年8月23日 下午2:26:07   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2017 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
public interface IMessageEnum {
	  /**
	   * 
	   * @Title: getMessageCode   
	   * @Description: 获取信息编码  
	   * @param: @return      
	   * @return: int      
	   * @throws
	   */
      public int getMessageCode();
      /**
       * 
       * @Title: getMessageCodeDesc   
       * @Description: 获取编码描述   
       * @param: @return      
       * @return: String      
       * @throws
       */
      public String getMessageCodeDesc();
}
