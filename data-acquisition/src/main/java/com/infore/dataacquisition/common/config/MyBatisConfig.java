package com.infore.dataacquisition.common.config;

/******************************************************************************
 * All Rights Reserved.
 * 本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 *
 * All rights Reserved, Designed By www.infore.com
 * @Title:  CorsConfig.java
 * @Package com.infore.platform.common.config
 * @Description:  mybatis 配置
 * @author: Administrator
 * @date:   2017年9月8日 上午8:59:45
 * @version V1.0
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2017 www.infore.com Inc. All rights reserved.
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
@Configuration
@MapperScan(basePackages = {"com.infore.**.mapper"},sqlSessionFactoryRef = "platformSqlSessionFactory")
public class MyBatisConfig {

    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.password}")
    private String jdbcPassword;
    @Value("${mybatis.basePackage}")
    private String basePackage;
    @Value("${mybatis.mapperLocations}")
    private String mapperLocations;
    
    @Value("${druid.initialSize}")
    private String initialSize;
    @Value("${druid.minIdle}")
    private String minIdle;
    @Value("${druid.maxActive}")
    private String maxActive;
    @Value("${druid.maxWait}")
    private String maxWait;
    @Value("${druid.removeAbandoned}")
    private String removeAbandoned;
    @Value("${druid.removeAbandonedTimeout}")
    private String removeAbandonedTimeout;
    @Value("${druid.testWhileIdle}")
    private String testWhileIdle;
    @Value("${druid.testOnBorrow}")
    private String testOnBorrow;
    @Value("${druid.poolPreparedStatements}")
    private String poolPreparedStatements;
    @Value("${druid.maxPoolPreparedStatementPerConnectionSize}")
    private String maxPoolPreparedStatementPerConnectionSize;
    
    @Value("${dbType}")
    private String dbType;

    /**
     * 创建数据源
     *
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
     */
    @Primary
    @Bean(name="platformDataSource")
    public DataSource getDataSource() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", driverClassName);
        props.put("url", jdbcUrl);
        props.put("username", jdbcUsername);
        props.put("password", jdbcPassword);
        
        //下面为连接池的补充设置，应用到上面所有数据源中  
        
        props.put("initialSize", initialSize);
        props.put("minIdle",minIdle);
        props.put("maxActive", maxActive);
        props.put("maxWait", maxWait);
        props.put("removeAbandoned", removeAbandoned);
        props.put("removeAbandonedTimeout",removeAbandonedTimeout);
        props.put("testWhileIdle",testWhileIdle);
        props.put("testOnBorrow",testOnBorrow);
        props.put("poolPreparedStatements",poolPreparedStatements);
        props.put("maxPoolPreparedStatementPerConnectionSize",maxPoolPreparedStatementPerConnectionSize);

        if("oracle".equalsIgnoreCase(dbType)){
        	 props.put("validationQuery","select 1 from dual ");
        }else if("mysql".equalsIgnoreCase(dbType)){
        	props.put("validationQuery","select 1 ");
        }else if("sqlserver".equalsIgnoreCase(dbType)){
        	props.put("validationQuery","select 1 ");
        }
        return DruidDataSourceFactory.createDataSource(props);
    }

    @Primary
    @Bean(name = "platformTransactionManager")
    public PlatformTransactionManager txManager() throws Exception {
        return new DataSourceTransactionManager(getDataSource());
    }

    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Primary
    @Bean(name = "platformSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("platformDataSource") DataSource getDataSource) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(getDataSource);//指定数据源(这个必须有，否则报错)
        fb.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        //下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
        fb.setTypeAliasesPackage(basePackage);//指定基包
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));//指定xml文件位置
        return fb.getObject();
    }

}
