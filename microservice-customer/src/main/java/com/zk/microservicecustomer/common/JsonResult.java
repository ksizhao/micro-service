package com.zk.microservicecustomer.common;

import java.io.Serializable;

public class JsonResult<T> implements Serializable {

    private static final long serialVersionUID = 6368599512945110678L;
    private String message;

    private String code;

    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public JsonResult(String message, String code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }
}
