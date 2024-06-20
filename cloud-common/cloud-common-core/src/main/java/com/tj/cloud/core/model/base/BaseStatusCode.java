/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.core.model.base;

import com.tj.cloud.core.idal.IStatusCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @AUTHOR:taoJun
 * @Date:2022/1/11
 * @Description:
 * @version:1.0
 */
@Data
@ApiModel("请求状态类")
public class BaseStatusCode implements IStatusCode {

	@ApiModelProperty("状态码")
	private int code;

	public BaseStatusCode(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	@ApiModelProperty("来源系统")
	private String system;

	@ApiModelProperty("状态描述")
	private String desc;

}
