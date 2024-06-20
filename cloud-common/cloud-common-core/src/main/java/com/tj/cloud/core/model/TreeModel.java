/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.core.model;

import java.util.List;

/**
 * @AUTHOR:taoJun
 * @Date:2024/3/14
 * @Description:
 * @version:1.0
 */
public interface TreeModel<T extends TreeModel<?>> {

	/**
	 * 获取主键ID
	 * @return id
	 */
	String getId();

	/**
	 * 获取上级ID
	 * @return id
	 */
	String getParentId();

	/**
	 * 获取子对象
	 * @return List<T>
	 */
	List<T> getChildrenList();

	/**
	 * 设置子对象
	 * @param list
	 */
	void setChildrenList(List<T> list);

}
