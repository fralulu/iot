package com.infore.dataacquisition.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.infore.platform.core.redis.Redis;

/**
 * 
 * All rights Reserved, Designed By www.infore.com
 * @Title:  RedisSpringConfig.java   
 * @Package com.infore.platform.common.config   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: zhangyong  
 * @date:   2017年8月22日 下午7:44:02   
 * @version V1.0 
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2017 www.infore.com Inc. All rights reserved. 
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
//@Configuration
public class RedisConfig {
	
    @Bean
    public Redis redis(@Value("${redis.node1.host}") String host, @Value("${redis.node1.port:6379}") Integer port,
                       @Value("${redis.node1.password:}") String password) {
        password = "".equals(password) ? null : password;
        return new Redis(host, port, password);
    }
}
