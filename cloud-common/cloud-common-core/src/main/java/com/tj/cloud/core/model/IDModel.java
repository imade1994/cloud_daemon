/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.core.model;

import java.io.Serializable;

/**
 * @AUTHOR:taoJun
 * @Date:2024/3/14
 * @Description:
 * @version:1.0
 */
public interface IDModel extends Serializable {

	/**
	 * 获取ID
	 * @return id
	 */
	String getId();

	/**
	 * 设置ID
	 * @param id
	 */
	void setId(String id);

}
