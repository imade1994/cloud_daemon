/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.core.model.base;

import com.tj.cloud.core.model.BaseModel;
import lombok.*;

import java.io.Serializable;

/**
 * @AUTHOR:taoJun
 * @Date:2023/2/3
 * @Description:
 * @version:1.0
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseLog extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 4564814442231976810L;

	/**
	 * 日志类型
	 */
	private String type;

	/**
	 * 日志标题
	 */
	private String title;

	/**
	 * 操作IP地址
	 */
	private String remoteAddr;

	/**
	 * 用户浏览器
	 */
	private String userAgent;

	/**
	 * 请求URI
	 */
	private String requestUri;

	/**
	 * 操作方式
	 */
	private String method;

	/**
	 * 操作提交的数据
	 */
	private String params;

	/**
	 * 执行时间
	 */
	private Long time;

	/**
	 * 异常信息
	 */
	private String exception;

	/**
	 * 服务ID
	 */
	private String serviceId;

}
