/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.core.model.base;

import com.tj.cloud.core.enumeration.BaseStatusCodeEnum;
import com.tj.cloud.core.idal.IResult;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @AUTHOR:taoJun
 * @Date:2023/2/3
 * @Description: 标准返回实现
 * @version:1.0
 */
@Getter
@Setter
public class BaseResult implements IResult {

    private static final long serialVersionUID = 2508948994192512183L;
    /**
     * 本次调用是否成功
     */
    @ApiModelProperty("本次调用是否成功")
    private Boolean isOk;

    /**
     * 操作提示信息
     */
    @ApiModelProperty("操作提示信息")
    private String msg;

    /**
     * 异常堆栈信息
     */
    @ApiModelProperty("异常堆栈信息")
    private String cause;

    /**
     * 状态码
     */
    @ApiModelProperty("状态码")
    private int code;




    public void setIsOk(Boolean ok) {
        if (ok) {
            this.setCode(BaseStatusCodeEnum.SUCCESS.getCode());
        }
        isOk = ok;
    }

    @Override
    public Boolean getIsOk() {
        return isOk;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public String getCause() {
        return cause;
    }
}
