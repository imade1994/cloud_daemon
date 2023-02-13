/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.db.manager.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tj.cloud.db.manager.BaseManager;
import com.tj.cloud.db.mapper.CloudBaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @AUTHOR:taoJun
 * @Date:2023/2/3
 * @Description:
 * @version:1.0
 */
@Service
public abstract class BaseManagerImpl<M extends CloudBaseMapper<T>,T> extends ServiceImpl<M,T> implements BaseManager<T> {
    @Override
    public Integer insertBatchSomeColumn(List<T> entityList) {
        return baseMapper.insertBatchSomeColumn(entityList);
    }

    @Override
    public Integer insertOrUpdateBatch(List<T> entityList) {
        return baseMapper.insertOrUpdateBatch(entityList);
    }

    @Override
    public Integer insertOrUpdateSelectiveBatch(List<T> entityList) {
        return baseMapper.insertOrUpdateSelectiveBatch(entityList);
    }
}
