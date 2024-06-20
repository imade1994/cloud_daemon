/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.core.annotation;

import java.lang.annotation.*;

/**
 * @AUTHOR:taoJun
 * @Date:2022/1/11
 * @Description: 如果该注解的方法出现异常，则会反馈标准的异常结果【ResultMsg.java】给前端或者服务调用方,
 * 若异常为BusException则不会记录日志
 * @version:1.0
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CatchError {

	String value() default "";

	/**
	 * 目前全部都是 RestController 请确认是否需要写入 response 形式
	 */
	boolean write2response() default false;

}
