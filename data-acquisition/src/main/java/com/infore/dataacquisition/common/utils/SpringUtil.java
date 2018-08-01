package com.infore.dataacquisition.common.utils;

import org.springframework.beans.BeansException;


import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringUtil implements ApplicationContextAware{
	
	private static ApplicationContext applicationContext = null;
    @Override  
    public void setApplicationContext(ApplicationContext context)throws BeansException {  
        SpringUtil.applicationContext =context;  
    }  
    public static Object getBean(String name){
        return applicationContext.getBean(name);  
    }   
    
}
