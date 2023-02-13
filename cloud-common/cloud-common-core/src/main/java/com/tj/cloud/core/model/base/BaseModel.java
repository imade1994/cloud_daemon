/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.core.model.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @AUTHOR:taoJun
 * @Date:2023/2/3
 * @Description:
 * @version:1.0
 */
@Getter
@Setter
public class BaseModel implements Serializable {


    private static final long serialVersionUID = -6755224135318065081L;
    /**
     * 主键ID -snowFakerID
     * */
    private String id;

    /**
     * delete flag 删除标记
     * */
    private int delFlag;


    /**
     * 创建时间
     * */
    private LocalDateTime createDate;



    /**
     * 创建人ID
     * */
    private String creator;



    /**
     * 更新人 id
     * */
    private String updater;


    /**
     * 更新时间
     * */
    private LocalDateTime updateDate;




}
