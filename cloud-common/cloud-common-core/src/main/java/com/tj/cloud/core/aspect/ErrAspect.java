/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.core.aspect;

import com.tj.cloud.core.annotation.CatchError;
import com.tj.cloud.core.enumeration.BaseStatusCodeEnum;
import com.tj.cloud.core.enumeration.EnvironmentEnum;
import com.tj.cloud.core.exception.BusinessError;
import com.tj.cloud.core.exception.BusinessException;
import com.tj.cloud.core.exception.BusinessMessage;
import com.tj.cloud.core.idal.IStatusCode;
import com.tj.cloud.core.model.base.ResultMsg;
import com.tj.cloud.core.util.ApplicationUtils;
import com.tj.cloud.core.util.ExceptionUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @AUTHOR:taoJun
 * @Date:2022/2/22
 * @Description:
 * @version:1.0
 */
@Aspect
@Component
public class ErrAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(ErrAspect.class);

	@Around(value = "@annotation(catchError)")
	public Object doAudit(ProceedingJoinPoint point, CatchError catchError) throws Throwable {
		Object returnVal = null;
		try {
			returnVal = point.proceed();
		}
		catch (Exception ex) {
			// 如果非业务异常则记录日志
			String errorMessage = ExceptionUtil.getRootErrorMessage(ex);
			ResultMsg resultMsg = null;
			// 业务消息异常则直接返回给前端
			if (!(ex instanceof BusinessMessage)) {
				LOGGER.error("操作出现异常     {}.{} ", point.getTarget().getClass(), point.getSignature().getName(), ex);
				IStatusCode errorStatusCode = BaseStatusCodeEnum.SYSTEM_ERROR;
				// 假如是包装异常则获取具体异常码，以及包装后的异常信息
				if (ex instanceof BusinessException) {
					errorStatusCode = ((BusinessException) ex).getIStatusCode();
					errorMessage = ex.getMessage();
				}
				else if (ex instanceof BusinessError) {
					errorStatusCode = ((BusinessError) ex).getStatusCode();
					errorMessage = ex.getMessage();
				}
				// 生产环境 提示 系统异常
				if (ApplicationUtils.getCtxEnvironment().contains(EnvironmentEnum.PROD.key())) {
					resultMsg = new ResultMsg(errorStatusCode, errorStatusCode.getDesc());
				}
				else {

				}
			}
			else {
				BusinessMessage busEx = (BusinessMessage) ex;
				errorMessage = ex.getMessage();
				resultMsg = new ResultMsg(busEx.getStatusCode(), errorMessage);

			}

			// 若返回值是resultType 则返回错误
			org.aspectj.lang.Signature signature = point.getSignature();
			Class returnType = ((MethodSignature) signature).getReturnType();
			if (resultMsg.getMsg().indexOf(BaseStatusCodeEnum.FULL_AUTHENTICATION.getDesc()) != -1
					|| resultMsg.getMsg().indexOf(BaseStatusCodeEnum.ACCESS_TOKEN_EXPIRE.getDesc()) != -1) {
				resultMsg.setMsg("登录信息已失效！请重新登录");
			}
			if (returnType.isAssignableFrom(ResultMsg.class)) {
				return resultMsg;
			}
		}

		return returnVal;
	}

}
