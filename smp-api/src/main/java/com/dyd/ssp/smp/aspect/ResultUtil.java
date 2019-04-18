package com.dyd.ssp.smp.aspect;

import org.springframework.http.HttpStatus;

/**
 * 包装统一返回相应参数
 */
public class ResultUtil {

    public ResultUtil() {
    }

    public static <T> ResultModel<T> notFound(String message) {
        ResultModel response = new ResultModel();
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setCode(HttpStatus.NOT_FOUND.getReasonPhrase());
        response.setMessage(message);
        return response;
    }

    public static <T> ResultModel<T> internalServerError(String message) {
        ResultModel response = new ResultModel();
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        response.setMessage(message);
        return response;
    }

    public static <T> ResultModel<T> validationFailure(String message) {
        ResultModel response = new ResultModel();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setCode(HttpStatus.BAD_REQUEST.getReasonPhrase());
        response.setMessage(message);
        return response;
    }

    public static <T> ResultModel<T> buildResponseModel(T result) {
        ResultModel response = new ResultModel();
        response.setStatus(HttpStatus.OK.value());
        response.setCode(HttpStatus.OK.getReasonPhrase());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        response.setResult(result);
        return response;
    }
}
