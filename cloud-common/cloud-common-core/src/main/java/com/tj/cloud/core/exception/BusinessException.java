/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.core.exception;


import com.tj.cloud.core.enumeration.BaseStatusCodeEnum;
import com.tj.cloud.core.idal.IStatusCode;

/**
 * @AUTHOR:taoJun
 * @Date:2021/10/14
 * @Description: 业务逻辑异常，常常为可预料异常.
 * @version:1.0
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -3099347582022476131L;

    public IStatusCode statusCode = BaseStatusCodeEnum.BUSINESS_ERROR;

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public BusinessException(Throwable throwable) {
        super(throwable);
    }

    /**
     * 格式化的异常消息，
     *
     * @param msgTemplate 如：账户[%s]对应密码不正确
     * @param params      对应 msgTemplate %s 入参,按顺序填入
     */
    public BusinessException(String msgTemplate, String... params) {
        super(String.format(msgTemplate, params));
    }

    /**
     * 自定义异常MSG
     *
     * @param msg
     * @param errorCode
     */
    public BusinessException(String msg, IStatusCode errorCode) {
        super(msg);
        this.statusCode = errorCode;
    }

    /**
     * 使用异常码的异常描述
     *
     * @param errorCode
     */
    public BusinessException(IStatusCode errorCode) {
        super(errorCode.getDesc());
        this.statusCode = errorCode;
    }

    public BusinessException(IStatusCode errorCode, Throwable throwable) {
        super(String.format("%s,可能的原因为：%s", errorCode.getDesc(), throwable.getMessage()), throwable);
        this.statusCode = errorCode;
    }

    /**
     * 异常包装后抛出
     *
     * @param msg
     * @param errorCode
     * @param throwable
     */
    public BusinessException(String msg, IStatusCode errorCode, Throwable throwable) {
        super(String.format("%s[%s],可能的原因为：%s", errorCode.getDesc(), msg, throwable.getMessage()), throwable);
        this.statusCode = errorCode;
    }


    public IStatusCode getIStatusCode() {
        return statusCode;
    }

    public void setStatusCode(IStatusCode statusCode) {
        this.statusCode = statusCode;
    }
}
