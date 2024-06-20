/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.core.idal;

import java.io.Serializable;

/**
 * @AUTHOR:taoJun
 * @Date:2023/2/3
 * @Description: 标准返回接口
 * @version:1.0
 */
public interface IResult extends Serializable {

	/**
	 * 本地调用是否成功
	 * @return
	 */
	Boolean getIsOk();

	/**
	 * 调用状态码
	 * @return
	 */
	int getCode();

	/**
	 * 调用信息
	 * @return
	 */
	String getMsg();

	/**
	 * 调用出错堆栈信息
	 * @return
	 */
	String getCause();

}
