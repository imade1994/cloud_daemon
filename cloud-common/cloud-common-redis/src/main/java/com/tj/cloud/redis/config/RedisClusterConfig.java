/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.redis.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @AUTHOR:taoJun
 * @Date:2023/2/3
 * @Description:
 * @version:1.0
 */
@Configuration
@ConditionalOnProperty(prefix = "com.tj.cloud",name="model",havingValue = "cluster")
@EnableConfigurationProperties(RedisClusterConfig.class)
public class RedisClusterConfig {

}
