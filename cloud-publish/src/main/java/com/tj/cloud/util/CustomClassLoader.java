/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.util;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @AUTHOR:taoJun
 * @Date:2024/6/17
 * @Description:
 * @version:1.0
 */
public class CustomClassLoader extends ClassLoader{

    protected static final String FILE_PATH = "file:///E:/classes/com/hlxd/dynamic/";
    protected static final String CLASS_NAME = "com.hlxd.dynamic";
    protected static final String CLASS_ENTITY_NAME = ".entity.";
    protected static final String CLASS_CONTROLLER_NAME = ".controller.";
    protected static final String CLASS_MAPPER_NAME = ".mapper.";
    protected static final String CLASS_SERVICE_NAME = ".service.";
    protected static final String CLASS_SERVICE_IMPL_NAME = ".service.impl.";


    protected static final String ENTITY_PATH = "entity/";
    protected static final String MAPPER_PATH = "mapper/";
    protected static final String SERVICE_PATH = "service/";
    protected static final String SERVICE_IMPL_PATH = "service/impl/";
    protected static final String CONTROLLER_PATH = "controller/";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String[] namesSplit = name.split("[.]");
        String filePath ;
        String className;
        if(name.startsWith("com.hlxd.dynamic")){
            String lastName = namesSplit[namesSplit.length-1];
            if(lastName.startsWith("I") && lastName.endsWith("Service")){
                filePath  = FILE_PATH.concat(SERVICE_PATH).concat(lastName).concat(".class");
                className = CLASS_NAME.concat(CLASS_SERVICE_NAME);
            }  else if(lastName.endsWith("Mapper")){
                filePath = FILE_PATH.concat(MAPPER_PATH).concat(lastName).concat(".class");
                className = CLASS_NAME.concat(CLASS_MAPPER_NAME);
            }  else if(lastName.endsWith("Impl")){
                filePath = FILE_PATH.concat(SERVICE_IMPL_PATH).concat(lastName).concat(".class");
                className = CLASS_NAME.concat(CLASS_SERVICE_IMPL_NAME);
            } else if(lastName.endsWith("Controller")){
                filePath = FILE_PATH.concat(CONTROLLER_PATH).concat(lastName).concat(".class");
                className = CLASS_NAME.concat(CLASS_CONTROLLER_NAME);
            } else{
                filePath = FILE_PATH.concat(ENTITY_PATH).concat(lastName).concat(".class");
                className = CLASS_NAME.concat(CLASS_ENTITY_NAME);
            }
            byte[] clzBytes;
            try{
                Path path = Paths.get(new URI(filePath));
                clzBytes = Files.readAllBytes(path);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Class<?> clz = defineClass(className.concat(lastName),clzBytes,0,clzBytes.length);
            return clz;
        }else{
            return super.findClass(name);
        }
    }
}
