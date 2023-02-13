/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @AUTHOR:taoJun
 * @Date:2023/2/3
 * @Description:
 * @version:1.0
 */
public interface CloudBaseMapper<T> extends BaseMapper<T> {

    /**
     * 批量插入 仅适用于 mysql
     * @param entityList 实体列表
     * @return 影响行数
     */
    Integer insertBatchSomeColumn(List<T> entityList);

    /**
     * 批量新增或修改
     * @param entityList 批量数据
     * @return 新增或修改结果
     */
    Integer insertOrUpdateBatch(List<T> entityList);

    /**
     * 可选批量新增或修改
     * @param entityList 批量数据
     * @return 新增或修改结果
     */
    Integer insertOrUpdateSelectiveBatch(List<T> entityList);
}
