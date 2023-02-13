/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.core.idal;

/**
 * @AUTHOR:taoJun
 * @Date:2023/2/3
 * @Description: 抽象状态接口
 * @version:1.0
 */
public interface IStatusCode {

    /**
     * 状态码
     * @return
     */
    int getCode();

    /**
     * 异常信息
     * @return
     */
    String getDesc();

    /**
     * 系统编码
     * @return
     */
    String getSystem();
}
