/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.core.model.base;

/**
 * @AUTHOR:taoJun
 * @Date:2024/6/18
 * @Description:
 * @version:1.0
 */
public enum IndexEnum {

	INDEX_SINGLE("单独索引", "0"),

	INDEX_MANY("聚簇索引", "1");

	private String indexType;

	private String indexValue;

	IndexEnum(String indexType, String indexValue) {
		this.indexType = indexType;
		this.indexValue = indexValue;
	}

}
