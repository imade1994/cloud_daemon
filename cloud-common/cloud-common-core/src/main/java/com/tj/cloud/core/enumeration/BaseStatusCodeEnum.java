/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.core.enumeration;

import com.tj.cloud.core.idal.IStatusCode;

/**
 * @AUTHOR:taoJun
 * @Date:2023/2/3
 * @Description:
 * @version:1.0
 */
public enum BaseStatusCodeEnum implements IStatusCode {

	/**
	 * 成功
	 */
	SUCCESS(200, "成功"),

	/**
	 * 权限受限
	 */
	FULL_AUTHENTICATION(1401, "Full authentication"),

	/**
	 * 凭证已过期
	 */
	ACCESS_TOKEN_EXPIRE(1401, "Access token expired"),

	/**
	 * 系统异常
	 */
	SYSTEM_ERROR(1001, "系统异常"),

	/**
	 * 业务逻辑异常
	 */
	BUSINESS_ERROR(1002, "逻辑异常"),

	/**
	 * 访问超时
	 */
	TIMEOUT(1401, "访问超时"),

	/**
	 * 多地登录
	 */
	LOGIN_DIFFERENT(1402, "异地登录"),

	/**
	 * 当前用户 登录地异常
	 */
	LOGIN_UN_SAFETY(1404, "当前用户登录环境异常"),

	/**
	 * 访问受限
	 */
	NO_ACCESS(1403, "访问受限"),

	/**
	 * 参数校验不通过
	 */
	PARAM_ILLEGAL(1100, "参数校验不通过"),

	/**
	 * 数据已存在
	 */
	DATA_EXISTS(1101, "数据已存在"),

	NOT_SUPPORT(1103, "不支持的方法"),

	/**
	 * 远程调用服务失败
	 */
	REMOTE_ERROR(1102, "远程调用服务失败"),

	SERIAL_NUMBER_EXIST(50001, "流水号已存在"), SERIAL_NUMBER_NOT_EXIST(50002, "流水号不存在");

	/**
	 * 编码
	 */
	private int code;

	/**
	 * 描述
	 */
	private String desc;

	/**
	 * 系统
	 */
	private String system;

	BaseStatusCodeEnum(int code, String description) {
		this.code = code;
		this.desc = description;
		this.system = "tj.cloud";
	}

	@Override
	public int getCode() {
		return this.code;
	}

	@Override
	public String getDesc() {
		return this.desc;
	}

	@Override
	public String getSystem() {
		return this.system;
	}

}
