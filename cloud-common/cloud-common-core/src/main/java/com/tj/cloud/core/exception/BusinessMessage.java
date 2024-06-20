/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.core.exception;

import com.tj.cloud.core.enumeration.BaseStatusCodeEnum;
import com.tj.cloud.core.idal.IStatusCode;

/**
 * @AUTHOR:taoJun
 * @Date:2024/6/20
 * @Description:
 * @version:1.0
 */
public class BusinessMessage extends RuntimeException {

	public IStatusCode statusCode = BaseStatusCodeEnum.SYSTEM_ERROR;

	public BusinessMessage(String msg) {
		super(msg);
	}

	public BusinessMessage(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	/**
	 * 格式化的异常消息，
	 * @param msgTemplate 如：账户[%s]对应密码不正确
	 * @param params 对应 msgTemplate %s 入参,按顺序填入
	 */
	public BusinessMessage(String msgTemplate, String... params) {
		super(String.format(msgTemplate, params));
	}

	public BusinessMessage(Throwable throwable) {
		super(throwable);
	}

	public BusinessMessage(String msg, IStatusCode errorCode) {
		super(msg);
		this.statusCode = errorCode;
	}

	public BusinessMessage(IStatusCode errorCode) {
		super(errorCode.getDesc());
		this.statusCode = errorCode;
	}

	public BusinessMessage(IStatusCode errorCode, Throwable throwable) {
		super(errorCode.getDesc(), throwable);
		this.statusCode = errorCode;
	}

	public BusinessMessage(String msg, IStatusCode errorCode, Throwable throwable) {
		super(errorCode.getDesc() + ":" + msg, throwable);
		this.statusCode = errorCode;
	}

	public int getStringStatusCode() {
		if (statusCode == null)
			return 0;
		return statusCode.getCode();
	}

	public IStatusCode getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(IStatusCode statusCode) {
		this.statusCode = statusCode;
	}

}
