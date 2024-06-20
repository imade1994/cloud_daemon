/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @AUTHOR:taoJun
 * @Date:2024/6/18
 * @Description:
 * @version:1.0
 */
public class ServiceProxy<T> implements InvocationHandler {

    private static final Logger log = LoggerFactory.getLogger(ServiceProxy.class);


    private Class<T> interfaceType;

    public ServiceProxy(Class<T> ifType) {
        this.interfaceType = ifType;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("代理开始....");
        Object result = method.invoke(interfaceType, args);
        log.info("代理结束...");
        return result;
    }
}
