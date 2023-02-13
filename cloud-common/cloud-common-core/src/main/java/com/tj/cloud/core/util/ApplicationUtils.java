/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.core.util;

import cn.hutool.core.util.ArrayUtil;
import com.tj.cloud.core.enumeration.BaseStatusCodeEnum;
import com.tj.cloud.core.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @AUTHOR:taoJun
 * @Date:2023/2/6
 * @Description:
 * @version:1.0
 */
@Component
public class ApplicationUtils implements ApplicationContextAware {

    protected static final Logger LOGGER = LoggerFactory.getLogger(ApplicationUtils.class);


    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationUtils.context = applicationContext;
    }

    /**
     * 获取spring容器上下文。
     *
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return context;
    }

    /**
     * 根据beanId获取配置在系统中的对象实例。
     */
    public static Object getBean(String beanId) {
        try {
            return context.getBean(beanId);
        } catch (Exception ex) {
            LOGGER.debug("getBean:" + beanId + "," + ex.getMessage());
        }
        return null;
    }

    /**
     * 获取Spring容器的Bean
     */
    public static <T> T getBean(Class<T> beanClass) {
        try {
            return context.getBean(beanClass);
        } catch (Exception ex) {
            LOGGER.debug("getBean:" + beanClass + "," + ex.getMessage());
        }
        return null;
    }


    /**
     * 获取接口的实现类实例。
     */
    public static <T> Map<String, T> getImplInstance(Class<T> clazz) {
        return context.getBeansOfType(clazz);
    }

    public static <T> List<T> getImplInstanceArray(Class<T> clazz) {
        List<T> list = new ArrayList<>();

        Map<String, T> map = context.getBeansOfType(clazz);

        for (T t : map.values()) {
            list.add(t);
        }
        return list;
    }


    /**
     * 发布事件
     */
    public static void publishEvent(ApplicationEvent event) {
        if (context != null) {
            context.publishEvent(event);
        }
    }


    /**
     * 获取当前系统环境<br>
     * 目前仅支持单一环境配置。请勿配置多个参数 dev sit 之类。 环境配置的判断参考下面代码<br>
     * doGetActiveProfiles().contains(profile) || (doGetActiveProfiles().isEmpty() && doGetDefaultProfiles().contains(profile))
     */
    private static String currentProfiles = null;

    public static String getCtxEnvironment() {
        if (currentProfiles != null) {
            return currentProfiles;
        }
        Environment environment = context.getEnvironment();
        String[] activeProfiles = environment.getActiveProfiles();
        if (ArrayUtil.isNotEmpty(activeProfiles)) {
            currentProfiles = activeProfiles[0];
            return currentProfiles;
        }
        String[] defaultProfiles = environment.getDefaultProfiles();
        if (ArrayUtil.isNotEmpty(defaultProfiles)) {
            currentProfiles = defaultProfiles[0];
            return defaultProfiles[0];
        }
        throw new BusinessException("查找不到正确的环境属性配置！", BaseStatusCodeEnum.SYSTEM_ERROR);
    }
}
