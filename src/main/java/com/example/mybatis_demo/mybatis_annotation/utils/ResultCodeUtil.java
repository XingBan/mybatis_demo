package com.example.mybatis_demo.mybatis_annotation.utils;

import com.example.mybatis_demo.mybatis_annotation.enums.ResultCode;
import com.example.mybatis_demo.mybatis_annotation.exception.ResultCodeException;
import com.example.mybatis_demo.mybatis_annotation.response.JsonResponse;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * 错误与异常辅助类
 */
public class ResultCodeUtil {

    /**
     * 检查是否为空
     * @param object
     * @param resultCode
     * @param details
     */
    public static void isNull(Object object, ResultCode resultCode, Object... details) {
        if (object == null) {
            pop(resultCode, details);
        }
    }

    /**
     * 抛出异常
     * @param resultCode
     * @param details
     */
    public static void pop(ResultCode resultCode, Object... details) {
        checkNotNull(resultCode);
        final JsonResponse errorResp = new JsonResponse(resultCode.code(), resultCode.message(), null);
        if (details.length > 0) {
            Optional.of(details).ifPresent(errorResp::setData);
        }
        String errorCode = String.valueOf(resultCode.code());
        bindStatusCodesInRequestScope(errorCode, errorResp);
        throw new ResultCodeException(errorCode, resultCode.message(),errorResp.getData());
    }

    /**
     * 对请求体设置错误码信息
     * @param key
     * @param jsonResponse
     */
    private static void bindStatusCodesInRequestScope(String key, JsonResponse jsonResponse) {
        checkNotNull(jsonResponse);
        checkNotNull(key);
        final RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            ((ServletRequestAttributes) requestAttributes).getRequest().setAttribute(key, jsonResponse);
        }
    }

}
