/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.db.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @AUTHOR:taoJun
 * @Date:2023/2/3
 * @Description:  基础业务 服务CRUD 暴露层
 * @version:1.0
 */
public interface BaseService<T> {


    /**
     * 抽象插入方法
     * @param t 抽象实体对象
     * @return int 影响条数
     * */
    Boolean add(T t);


    /**
     * 抽象插入方法
     * @param list 抽象实体对象
     * @return int 影响条数
     * */
    Integer batchAdd(List<T> list);


    /**
     * 抽象批量插入方法
     * @param ids 传入ID 参数 多个用,分割
     * @return int 返回影响条数
     * */
    int del(String... ids);


    /**
     * 抽象批量插入方法
     * @param t 实体参数
     * @return int 返回影响条数
     * */
    Boolean updateById(T t);


    /**
     * 查询方法
     * @param ids 查询实体ID 多个ID 用,分割
     * @return list 返回符合条件的数据
     * */
    List<T> queryByIds(String... ids);

    /**
     * 批量更新
     * @param t
     * */
    void batchAddOrUpdate(List<T> t);



    /**
     * 根据ID查询
     * @param id
     * @return T 抽象实体
     * */
    T queryById(String id);


    /**
     * 根据ID删除
     * @param id
     * @return 返回影响条数
     * */
    Boolean deleteById(String id);


    /**
     * 根据IDs 删除
     * @param ids
     * @return  返回影响条数
     * */
    Boolean deleteByIds(String... ids);


    /**
     * 根据wrappers 查询
     * @param queryWrapper
     * @return  返回影响条数
     * */
    List<T> getByWrappers(QueryWrapper queryWrapper);


    /**
     * 根据wrappers,page  查询
     * @param queryWrapper
     * @param page 分页参数
     * @return  分页结果
     * */
    Page<T> getPage(Page<T> page, QueryWrapper<T> queryWrapper);





}
