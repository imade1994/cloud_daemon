/*
 * Copyright (c) 2003-2021 www.hualongxunda.com/ Inc. All rights reserved.
 * 注意：本内容仅限于深圳华龙讯达信息技术股份有限公司内部传阅，禁止外泄以及用于其他商业目的。
 */
package com.tj.cloud.core.enumeration;

import org.springframework.util.StringUtils;

/**
 * @AUTHOR:taoJun
 * @Date:2024/6/20
 * @Description:
 * @version:1.0
 */
public enum EnvironmentEnum {

	DEV("DEV", ",开发-默认"), SIT("SIT", "测试"), PROD("PROD", "生产");

	private String key;

	private String value;

	EnvironmentEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String key() {
		return key;
	}

	public String value() {
		return value;
	}

	public static String getKes() {
		StringBuilder sb = new StringBuilder();
		for (EnvironmentEnum e : EnvironmentEnum.values()) {
			sb.append("[").append(e.key).append("]");
		}
		return sb.toString();
	}

	public static boolean contain(String key) {
		if (StringUtils.isEmpty(key))
			return false;

		for (EnvironmentEnum e : EnvironmentEnum.values()) {
			if (key.equals(e.key))
				return true;
		}
		return false;
	}

}
