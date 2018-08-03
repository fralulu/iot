package com.infore.platform.core.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By www.infore.com
 *
 * @version V1.0
 * @Title: SpringContextUtils.java
 * @Package com.infore.platform.core.common.utils
 * @Description: Spring的工具类，用来获得配置文件中的bean
 * @author: Administrator
 * @date: 2017年8月24日 下午7:30:15
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2017 www.infore.com Inc. All rights reserved.
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    /**
     * <p>Title: setApplicationContext</p>
     * <p>Description:当继承了ApplicationContextAware类之后，那么程序在调用 getBean(String)的时候会自动调用该方法，不用自己操作</p>
     *
     * @param applicationContext context
     * @throws BeansException exception
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtils.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * @param name name
     * @Title: getBean
     * @Description: 根据一个bean的id获取配置文件中相应的bean
     * @param: @return
     * @param: @throws BeansException
     * @return: Object
     * @throws BeansException exception
     */
    public static Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);
    }

    /**
     * @param requiredType name
     * @Title: getBean
     * @Description: 根据一个bean的类型获取配置文件中相应的bean
     * @param: @return
     * @param: @throws BeansException
     * @return: Object
     * @throws BeansException exception
     */
    public static Object getBean(Class<Object> requiredType) throws BeansException {
        return applicationContext.getBean(requiredType);
    }

    /**
     * @param name         name
     * @param requiredType type
     * @Title: getBean
     * @Description: 类似于getBean(String name)只是在参数中提供了需要返回到的类型。
     * @param: @return
     * @param: @throws BeansException
     * @return: Object
     * @throws BeansException exception
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Object getBean(String name, Class requiredType) throws BeansException {
        return applicationContext.getBean(name, requiredType);
    }

    /**
     * @param name name
     * @Title: containsBean
     * @Description: 如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true
     * @param: @return
     * @return: boolean
     * @throws BeansException exception
     */
    public static boolean containsBean(String name) {
        return applicationContext.containsBean(name);
    }

    /**
     * @param name name
     * @Title: isSingleton
     * @Description: 判断以给定名字注册的bean定义是一个singleton还是一个prototype。
     * 如果与给定名字相应的bean定义没有被找到，将会抛出一个异常（NoSuchBeanDefinitionException）
     * @param: @return
     * @param: @throws NoSuchBeanDefinitionException
     * @return: boolean
     * @throws NoSuchBeanDefinitionException exception
     */
    public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        return applicationContext.isSingleton(name);
    }


    /**
     * @param name name
     * @Title: getType
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param: @return Class 注册对象的类型
     * @param: @throws NoSuchBeanDefinitionException
     * @return: Class
     * @throws NoSuchBeanDefinitionException exception
     */
    @SuppressWarnings("rawtypes")
    public static Class getType(String name) throws NoSuchBeanDefinitionException {
        return applicationContext.getType(name);
    }


    /**
     * @param name name
     * @Title: getAliases
     * @Description: 如果给定的bean名字在bean定义中有别名，则返回这些别名
     * @param: @return
     * @param: @throws NoSuchBeanDefinitionException
     * @return: String[]
     * @throws NoSuchBeanDefinitionException exception
     */
    public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {
        return applicationContext.getAliases(name);
    }
}