/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.db.controller;

import com.tj.cloud.core.annotation.CatchError;
import com.tj.cloud.core.model.IDModel;
import com.tj.cloud.core.model.base.ResultMsg;
import com.tj.cloud.db.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static com.tj.cloud.core.constant.CommonConstant.BASE_CONSTANT_COMMA;

/**
 * @AUTHOR:taoJun
 * @Date:2023/2/3
 * @Description: 控制器CRUD抽象类
 * @version:1.0
 */
@RestController
public abstract class BaseController<T extends IDModel> extends ControllerTools {


    /**
     * 获取模块定义
     * @return String 返回模块定义
     * */
    protected abstract String getModelDesc();


    @Resource
    BaseService<T> service;

    @RequestMapping("getById")
    @CatchError
    public ResultMsg getById(@RequestParam("id")String id){
        return getSuccessResult(service.queryById(id));
    }


    @RequestMapping("getByIds")
    @CatchError
    public ResultMsg getByIds(@RequestParam("ids")String ids){
        return getSuccessResult(service.queryByIds(ids.split(BASE_CONSTANT_COMMA)));
    }


    @RequestMapping("save")
    @CatchError
    public ResultMsg save(@RequestBody T t){
        service.add(t);
        return getSuccessResult();
    }


    @RequestMapping("batchSave")
    @CatchError
    public ResultMsg batchSave(@RequestBody List<T> t){
        service.batchAdd(t);
        return getSuccessResult();
    }


    @RequestMapping("updateById")
    @CatchError
    public ResultMsg updateById(@RequestBody T t){
        service.updateById(t);
        return getSuccessResult();
    }


    @RequestMapping("batchAddOrUpdate")
    @CatchError
    public ResultMsg updateById(@RequestBody List<T> list){
        service.batchAddOrUpdate(list);
        return getSuccessResult();
    }


    @RequestMapping("deleteById")
    @CatchError
    public ResultMsg deleteById(@RequestParam("id")String id){
        service.deleteById(id);
        return getSuccessResult();
    }

    @RequestMapping("deleteByIds")
    @CatchError
    public ResultMsg deleteByIds(@RequestParam("ids")String ids){
        service.deleteByIds(ids.split(BASE_CONSTANT_COMMA));
        return getSuccessResult();
    }
}
