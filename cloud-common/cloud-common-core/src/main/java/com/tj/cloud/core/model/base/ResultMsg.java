/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.core.model.base;

import com.tj.cloud.core.enumeration.BaseStatusCodeEnum;
import com.tj.cloud.core.exception.BusinessException;
import com.tj.cloud.core.idal.IStatusCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @AUTHOR:taoJun
 * @Date:2023/2/3
 * @Description:
 * @version:1.0
 */
@ApiModel("标准结果返回类")
@Getter
@Setter
@NoArgsConstructor
public class ResultMsg<T> extends BaseResult {

    private static final long serialVersionUID = -8268721857430254901L;
    @ApiModelProperty("结果数据")
    private T data;



    public ResultMsg(T result) {
        this.setIsOk(Boolean.TRUE);
        this.setCode(BaseStatusCodeEnum.SUCCESS.getCode());
        this.setData(result);
    }

    public ResultMsg(IStatusCode code, String msg) {
        this.setIsOk(BaseStatusCodeEnum.SUCCESS.getCode()==code.getCode());
        this.setCode(code.getCode());
        this.setMsg(msg);
    }

    @Deprecated
    public ResultMsg(int code, String msg) {
        this.setCode(code);
        this.setIsOk(code == BaseStatusCodeEnum.SUCCESS.getCode());
        this.setMsg(msg);
    }


    public static <E> ResultMsg<E> ERROR(String msg) {
        ResultMsg<E> result = new ResultMsg<>();
        result.setIsOk(Boolean.FALSE);
        result.setMsg(msg);
        return result;
    }

    public static <E> ResultMsg<E> SUCCESS() {
        ResultMsg<E> result = new ResultMsg<>();
        result.setIsOk(Boolean.TRUE);
        return result;
    }

    public static <E> ResultMsg<E> SUCCESS(E data) {
        ResultMsg<E> result = new ResultMsg<>();
        result.setIsOk(Boolean.TRUE);
        result.setData(data);
        return result;
    }
}
