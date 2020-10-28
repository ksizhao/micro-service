package cn.ruvik.spring.cloud.alibaba.dubbo.gateway.common;

import org.apache.commons.lang.StringUtils;

/**
 * @author zhaolc
 * @version 1.0
 * @description TODO
 * @createTime 2020年10月27日 10:05:00
 */
public enum ENMsgCode {
    SUCCESS("0"),
    BUSINESS_ERROR("1"),
    SYSTEM_EXCEPTION("2"),
    NOT_LOG_IN("3"),
    SESSION_TIMEOUT("4"),
    WITHOUT_RIGHT("5"),
    CONFIG_ERROR("6");

    private String value;

    private ENMsgCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static boolean isSuccess(String value) {
        return StringUtils.equals(SUCCESS.value, value);
    }
}
