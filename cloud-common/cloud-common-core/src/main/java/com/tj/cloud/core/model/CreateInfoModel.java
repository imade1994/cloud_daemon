/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.core.model;

import java.time.LocalDateTime;

/**
 * @AUTHOR:taoJun
 * @Date:2024/3/14
 * @Description: 更新抽象模型
 * @version:1.0
 */
public interface CreateInfoModel {

	/**
	 * 返回创建时间
	 * @return LocalDateTime
	 */
	LocalDateTime getCreateTime();

	/**
	 * 设置创建时间
	 * @param localDateTime 创建时间
	 */
	void setCreateTime(LocalDateTime localDateTime);

	/**
	 * 返回更新时间
	 * @return LocalDateTime
	 */
	LocalDateTime getUpdateTime();

	/**
	 * 设置更新时间
	 * @param localDateTime 更新时间
	 */
	void setUpdateTime(LocalDateTime localDateTime);

	/**
	 * 设置创建人ID
	 * @param id 用户ID
	 */
	void setCreateUserId(String id);

	/**
	 * 返回创建人ID
	 * @return id
	 */
	String getCreateUserId();

	/**
	 * 获取更新人ID
	 * @return id
	 */
	String getUpdateBy();

	/**
	 * 设置更新人ID
	 * @param id
	 */
	void setUpdateBy(String id);

}
