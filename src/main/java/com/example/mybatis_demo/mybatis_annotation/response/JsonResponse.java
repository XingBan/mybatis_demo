package com.example.mybatis_demo.mybatis_annotation.response;



import com.example.mybatis_demo.mybatis_annotation.enums.BaseResultCode;

import java.io.Serializable;
import java.util.Objects;

/**
 * 控制器统一输出类
 * @param <T>
 */
public class JsonResponse<T> implements Serializable {

    private String code;
    private String message;
    private T data;

    public JsonResponse() {
    }

    public JsonResponse(String code, String message, T body) {
        this.code = code;
        this.message = message;
        this.data = body;
    }

    /**
     * 是否成功
     * @return
     */
    public boolean ok() {
        return Objects.equals(this.code, BaseResultCode.SUCCESS.code());
    }

    /**
     * 返回成功信息
     * @param body
     * @param <T>
     * @return
     */
    public static <T> JsonResponse<T> success(T body) {
        return new JsonResponse<>(BaseResultCode.SUCCESS.code(), BaseResultCode.SUCCESS.message(), body);
    }

    /**
     * 请求不存在
     * @return
     */
    public static <T> JsonResponse<T> systemNotFound() {
        return new JsonResponse<>(BaseResultCode.NOT_EXIST.code(), BaseResultCode.NOT_EXIST.message(), null);
    }

    /**
     * 服务器错误
     * @return
     */
    public static <T> JsonResponse<T> systemError() {
        return new JsonResponse<>(BaseResultCode.SYSTEM_ERROR.code(), BaseResultCode.SYSTEM_ERROR.message(), null);
    }

    /**
     * 自定义返回信息
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T> JsonResponse<T> customFail(String code, String message) {
        return new JsonResponse<>(code, message, null);
    }

    /**
     * 自定义返回信息
     * @param resp
     * @param <T>
     * @return
     */
    public static <T> JsonResponse<T> customFail(JsonResponse resp) {
        return new JsonResponse<>(resp.getCode(), resp.getMessage(), null);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
