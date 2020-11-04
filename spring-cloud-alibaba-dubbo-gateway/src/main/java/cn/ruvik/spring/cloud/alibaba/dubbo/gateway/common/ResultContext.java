package cn.ruvik.spring.cloud.alibaba.dubbo.gateway.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * @author zhaolc
 * @version 1.0
 * @description 返回消息包装类
 * @createTime 2020年10月27日 10:03:00
 */
public class ResultContext<T> implements Serializable {

    private String code;
    private String info;
    private String value;
    private Boolean success;
    private T data;

    public ResultContext(T data) {
        this();
        this.setData(data);
    }

    private ResultContext(String code, String info, String value, Boolean success) {
        this.code = code;
        this.info = info;
        this.value = value;
        this.success = success;
    }

    private ResultContext(String code, String info, Boolean success) {
        this.code = code;
        this.info = info;
        this.success = success;
    }

    public ResultContext(String code, String info, Boolean success, T data) {
        this.code = code;
        this.info = info;
        this.success = success;
        this.data = data;
    }

    public static ResultContext success(String info) {
        return new ResultContext(ENMsgCode.SUCCESS.getValue(), info, true);
    }

    public static ResultContext businessFail(String info, String value) {
        return new ResultContext(ENMsgCode.BUSINESS_ERROR.getValue(), info, value, false);
    }

    public static ResultContext systemException(String info, String value) {
        return new ResultContext(ENMsgCode.SYSTEM_EXCEPTION.getValue(), info, value, false);
    }

    public static <T> ResultContext<T> buildSuccess(String info, T data) {
        return new ResultContext<>(ENMsgCode.SUCCESS.getValue(), info, true,data );
    }

    @JsonIgnore
    public T getDataWithSuccess() throws Exception {
        if (!this.success) {
            throw new Exception(this.info);
        } else {
            return this.data;
        }
    }

    public String getCode() {
        return this.code;
    }

    public String getInfo() {
        return this.info;
    }

    public String getValue() {
        return this.value;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public T getData() {
        return this.data;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResultContext() {
    }
}
