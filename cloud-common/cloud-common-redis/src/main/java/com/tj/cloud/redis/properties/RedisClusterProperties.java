/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.redis.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @AUTHOR:taoJun
 * @Date:2023/2/3
 * @Description:
 * @version:1.0
 */
@ConfigurationProperties(prefix = "com.tj.cloud")
@RefreshScope
@Getter
@Setter
public class RedisClusterProperties {

    /**
     * redis 连接模式
     * cluster
     * single
     * */
    String model;


    /**
     * 获取链接是否判断
     * */
    boolean validate;


    /**
     * 最大转发次数
     * */
    int maxRedirect;



    /**
     * 节点
     * */
    String clusterNodes;



    /**
     * 用户名
     * */
    String username;


    /**
     * 密码
     * */
    String password;


    /**
     * 最大空闲连接数
     * */
    int maxIdle;


    /**
     * 最大连接数
     * */
    int maxActive;

    /**
     * 最大等待时长
     * */
    int maxWait;


    /**
     * 超时时间
     * */
    int timeOut;


    /**
     * 关闭最大超时时间
     * */
    int shutDownTime;


    /**
     * 刷新时间
     * */
    int refreshTime;






}
