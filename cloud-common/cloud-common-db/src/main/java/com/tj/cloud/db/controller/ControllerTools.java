/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.db.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tj.cloud.core.constant.CommonConstant;
import com.tj.cloud.core.model.base.ResultMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;

import static com.tj.cloud.core.constant.CommonConstant.*;

/**
 * @AUTHOR:taoJun
 * @Date:2023/2/3
 * @Description:
 * @version:1.0
 */
public class ControllerTools {

    private static final SimpleDateFormat sdf = new SimpleDateFormat(CommonConstant.YYYY_CONSTANT);

    private static final Logger logger = LoggerFactory.getLogger(ControllerTools.class);


    protected <T> ResultMsg<T> getSuccessResult(T data, String msg) {
        ResultMsg<T> resultMsg = new ResultMsg<T>();
        resultMsg.setIsOk(true);
        resultMsg.setMsg(msg);
        resultMsg.setData(data);
        return resultMsg;
    }

    protected <T> ResultMsg<T> getSuccessResult(T data) {
        ResultMsg<T> resultMsg = new ResultMsg<T>();
        resultMsg.setIsOk(true);
        resultMsg.setData(data);
        return resultMsg;
    }

    protected ResultMsg<String> getSuccessResult(String msg) {
        ResultMsg<String> resultMsg = new ResultMsg<String>();
        resultMsg.setIsOk(true);
        resultMsg.setMsg(msg);
        resultMsg.setData(msg);
        return resultMsg;
    }

    protected ResultMsg<String> getWarnResult(String msg) {
        ResultMsg<String> resultMsg = new ResultMsg<String>();
        resultMsg.setIsOk(false);
        resultMsg.setMsg(msg);
        return resultMsg;
    }

    protected <T> ResultMsg<T> getWarnResult(T data, String msg) {
        ResultMsg<T> resultMsg = new ResultMsg<T>();
        resultMsg.setData(data);
        resultMsg.setIsOk(false);
        resultMsg.setMsg(msg);
        return resultMsg;
    }

    protected ResultMsg<String> getSuccessResult() {
        ResultMsg<String> resultMsg = new ResultMsg<String>();
        resultMsg.setIsOk(true);
        resultMsg.setMsg("操作成功");
        return resultMsg;
    }
    protected <T> void setWrappers(QueryWrapper<T> queryWrapper,String column,Object value,String type){
        switch (type){
            case DBCONSTANT_OPERATION_TAG_EQ:
                queryWrapper.eq(column,value);
                break;
            case DBCONSTANT_OPERATION_TAG_LK:
                queryWrapper.like(column,value);
                break;
            default:
                break;
        }
    }




}
