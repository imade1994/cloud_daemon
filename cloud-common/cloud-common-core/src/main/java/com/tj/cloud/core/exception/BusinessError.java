/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.core.exception;

import com.tj.cloud.core.enumeration.BaseStatusCodeEnum;
import com.tj.cloud.core.idal.IStatusCode;

/**
 * @AUTHOR:taoJun
 * @Date:2022/2/22
 * @Description: 用户强制捕获的异常
 * @version:1.0
 */
public class BusinessError extends RuntimeException {

	public IStatusCode statusCode = BaseStatusCodeEnum.SYSTEM_ERROR;

	public BusinessError(String msg) {
		super(msg);
	}

	public BusinessError(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public BusinessError(Throwable throwable) {
		super(throwable);
	}

	public BusinessError(String msg, IStatusCode errorCode) {
		super(msg);
		this.statusCode = errorCode;
	}

	public BusinessError(IStatusCode errorCode) {
		super(errorCode.getDesc());
		this.statusCode = errorCode;
	}

	public BusinessError(IStatusCode errorCode, Throwable throwable) {
		super(errorCode.getDesc(), throwable);
		this.statusCode = errorCode;
	}

	public BusinessError(String msg, IStatusCode errorCode, Throwable throwable) {
		super(errorCode.getDesc() + ":" + msg, throwable);
		this.statusCode = errorCode;
	}

	public IStatusCode getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(IStatusCode statusCode) {
		this.statusCode = statusCode;
	}

}
