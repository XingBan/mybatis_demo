package com.example.mybatis_demo.mybatis_annotation.exception;

/**
 * 抛出异常类
 */
public class ResultCodeException extends RuntimeException {

    private String code;
    private String message;
    private Object data;

    public ResultCodeException(String message) {
        super(message);
    }

    public ResultCodeException(String code ,String message,Object data) {
        super(message);
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResultCodeException(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
