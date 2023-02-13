/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.log.annotation;

import java.lang.annotation.*;

/**
 * @AUTHOR:taoJun
 * @Date:2023/2/3
 * @Description: 操作日志注解
 * @version:1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SLog {
    /**
     * 描述
     */
    String value() default "";

    /**
     * SPEL 表达式
     * @return 日志描述
     */
    String expression() default "";
}
