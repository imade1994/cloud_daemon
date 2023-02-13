/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tj.cloud.db.manager.BaseManager;
import com.tj.cloud.db.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @AUTHOR:taoJun
 * @Date:2023/2/3
 * @Description:
 * @version:1.0
 */
@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {


    @Autowired
    private BaseManager<T> manager;



    @Override
    public Boolean add(T t) {
        return manager.save(t);
    }

    @Override
    public Integer batchAdd(List<T> t) {
        return manager.insertBatchSomeColumn(t);
    }

    @Override
    public Boolean  updateById(T t) {
        return manager.updateById(t);
    }

    @Override
    public void batchAddOrUpdate(List<T> t) {
        manager.insertOrUpdateBatch(t);
    }

    @Override
    public T queryById(String id) {
        return manager.getById(id);
    }

    @Override
    public List<T> queryByIds(String... ids) {
        return manager.listByIds(Arrays.asList(ids));
    }


    @Override
    public Boolean deleteById(String id) {
        return manager.removeById(id);
    }

    @Override
    public Boolean deleteByIds(String... ids) {
        return manager.removeBatchByIds(Arrays.asList(ids));
    }

    @Override
    public List<T> getByWrappers(QueryWrapper queryWrapper) {
        return manager.list(queryWrapper);
    }

    @Override
    public Page<T> getPage(Page<T> page, QueryWrapper<T> queryWrapper) {
        return manager.page(page,queryWrapper);
    }
}
