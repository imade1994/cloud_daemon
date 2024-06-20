/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.core.model.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @AUTHOR:taoJun
 * @Date:2024/6/18
 * @Description:
 * @version:1.0
 */
@Data
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -6755224135318065081L;

	@TableId(type = IdType.ASSIGN_ID)
	@ApiModelProperty(value = "主键id")
	private String id;

	@ApiModelProperty(value = "创建时间")
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

	@ApiModelProperty(value = "更新时间")
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;

	@ApiModelProperty(value = "创建人")
	@TableField(fill = FieldFill.INSERT)
	private String createBy;

	@ApiModelProperty(value = "更新人")
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String updateBy;

}
