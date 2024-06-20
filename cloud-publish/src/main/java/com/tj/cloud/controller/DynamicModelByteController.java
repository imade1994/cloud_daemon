/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.controller;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.core.MybatisMapperRegistry;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.tj.cloud.entity.DynamicModel;
import com.tj.cloud.service.IDynamicModelService;
import com.tj.cloud.util.CustomClassLoader;
import org.mybatis.spring.annotation.MapperScannerRegistrar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.*;
import java.nio.file.Files;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @AUTHOR:taoJun
 * @Date:2024/6/14
 * @Description:
 * @version:1.0
 */
@RestController
@RequestMapping("/publish")
public class DynamicModelByteController {

    @Resource
    IDynamicModelService dynamicModelService;







    @Resource
    ApplicationContext ctx;

    @GetMapping("/registryBean/{id}")
    public Object registryBean(@PathVariable("id")String id) throws ClassNotFoundException {
        Map<String,Object> objectMap = new HashMap<>();
        DynamicModel dynamicModel = dynamicModelService.getById(id);
        CustomClassLoader classLoader = new CustomClassLoader();
        objectMap.put(dynamicModel.getEntityName(),registerBean(classLoader,dynamicModel.getEntityName()));
        objectMap.put(dynamicModel.getMapperName(),registerBean(classLoader,dynamicModel.getMapperName()));
        objectMap.put(dynamicModel.getControllerName(),registerBean(classLoader,dynamicModel.getControllerName()));
        //objectMap.put(dynamicModel.getServiceName(),registerBean(classLoader,dynamicModel.getServiceName()));
        objectMap.put(dynamicModel.getServiceImplName(),registerBean(classLoader,dynamicModel.getServiceImplName()));

        return objectMap;

    }

    public Object registerBean(ClassLoader classLoader,String name) throws ClassNotFoundException {

        if(!ctx.containsBean(name)){
            Class<?> clz = classLoader.loadClass(name);
            ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) ctx;
            // 获取bean工厂并转换为DefaultListableBeanFactory

            if(name.contains("Mapper")){
                AbstractAutowireCapableBeanFactory abstractAutowireCapableBeanFactory = (AbstractAutowireCapableBeanFactory) configurableApplicationContext.getBeanFactory();
                /*AbstractBeanDefinition mapperBeanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
                mapperBeanDefinition.setBeanClass(clz);
                beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0,clz);*/
                abstractAutowireCapableBeanFactory.
                return null;
            }else{
                DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableApplicationContext.getBeanFactory();
                BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clz);
                BeanDefinition beanDefinition = beanDefinitionBuilder.getRawBeanDefinition();
                beanDefinition.setScope("singleton");
                defaultListableBeanFactory.registerBeanDefinition(name, beanDefinition);
                return defaultListableBeanFactory.getBean(name);
            }
        }else{
            return ctx.getBean(name);
        }
    }




}
