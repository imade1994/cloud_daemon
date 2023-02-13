/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.log.aspect;

import cn.hutool.core.util.StrUtil;
import com.tj.cloud.core.enumeration.LogTypeEnum;
import com.tj.cloud.log.annotation.SLog;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.EvaluationContext;

import java.io.Serializable;

/**
 * @AUTHOR:taoJun
 * @Date:2023/2/3
 * @Description:
 * @version:1.0
 */
@Aspect
public class LogAspect implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
    private static final long serialVersionUID = 4675767236499913089L;

    @Around("@annotation(sLog)")
    @SneakyThrows
    public Object around(ProceedingJoinPoint point, SLog sLog) {
        String strClassName = point.getTarget().getClass().getName();
        String strMethodName = point.getSignature().getName();
        logger.debug("[class]:{},[methods]:{}", strClassName, strMethodName);
        String value = sLog.value();
        String expression = sLog.expression();
        /**
         * 当前表达式存在 SPEL，会覆盖 value 的值
         * */
        if (StrUtil.isNotBlank(expression)) {
            /**
             * 解析SPEL
             * */
            MethodSignature signature = (MethodSignature) point.getSignature();
            EvaluationContext context = SysLogUtils.getContext(point.getArgs(), signature.getMethod());
            try {
                value = SysLogUtils.getValue(context, expression, String.class);
            }
            catch (Exception e) {
                /**
                 * SPEL 表达式异常，获取 value 的值
                 * */
                logger.error("@SLog explain SPEL {} exception", expression);
            }
        }

        SysLog logVo = SysLogUtils.getSysLog();
        logVo.setTitle(value);

        // 发送异步日志事件
        Long startTime = System.currentTimeMillis();
        Object obj;

        try {
            obj = point.proceed();
        }
        catch (Exception e) {
            logVo.setType(LogTypeEnum.ERROR.getType());
            logVo.setException(e.getMessage());
            throw e;
        }
        finally {
            Long endTime = System.currentTimeMillis();
            logVo.setTime(endTime - startTime);
            SpringContextHolder.publishEvent(new SysLogEvent(logVo));
        }

        return obj;
    }
}
