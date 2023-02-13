/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.core.idal;

import java.util.List;

/**
 * @AUTHOR:taoJun
 * @Date:2023/2/3
 * @Description: 树结构对象，用于将列表数据转换成树结构。
 * @version:1.0
 */
public interface Tree<C extends Tree<?>> {

    /**
     * 获取主键ID
     * @return
     */
    String getId();

    /**
     * 获取父ID
     * @return
     */
    String getParentId();

    /**
     * 获取子对象
     * @return
     */
    List<C> getChildren();

    /**
     * 设置子对象
     * @param list
     */
    void setChildren(List<C> list);
}
