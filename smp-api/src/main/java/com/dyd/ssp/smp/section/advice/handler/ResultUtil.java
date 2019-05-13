package com.dyd.ssp.smp.section.advice.handler;

import org.springframework.http.HttpStatus;

/**
 * 包装统一返回相应参数
 */
public class ResultUtil {

    public ResultUtil() {
    }

    public static <T> ResultModel<T> notFound(String message) {
        ResultModel response = new ResultModel();
        response.setCode(HttpStatus.NOT_FOUND.value());
        response.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
        response.setMessage(message);
        return response;
    }


    /**
     * 无权限异常 403
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResultModel<T> forbiddenRequestError(String message) {
        ResultModel response = new ResultModel();
        response.setCode(HttpStatus.FORBIDDEN.value());
        response.setStatus(HttpStatus.FORBIDDEN.getReasonPhrase());
        response.setMessage(message);
        return response;
    }



    /**
     * 系统错误异常 500
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResultModel<T> internalServerError(String message) {
        ResultModel response = new ResultModel();
        response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        response.setMessage(message);
        return response;
    }

    /**
     * 错误请求 400
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResultModel<T> validationFailure(String message) {
        ResultModel response = new ResultModel();
        response.setCode(HttpStatus.BAD_REQUEST.value());
        response.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
        response.setMessage(message);
        return response;
    }

    /**
     * 未认证   401
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResultModel<T> unauthorizedFailure(String message) {
        ResultModel response = new ResultModel();
        response.setCode(HttpStatus.UNAUTHORIZED.value());
        response.setStatus(HttpStatus.UNAUTHORIZED.getReasonPhrase());
        response.setMessage(message);
        return response;
    }

    /**
     * 登录成功 200
     * @param message
     * @param result
     * @param <T>
     * @return
     */
    public static <T> ResultModel<T> loginSuccessModel(String message,T result) {
        ResultModel response = new ResultModel();
        response.setCode(HttpStatus.OK.value());
        response.setStatus(HttpStatus.OK.getReasonPhrase());
        response.setMessage(message);
        response.setResult(result);
        return response;
    }


    /**
     * 成功 200
     * @param result
     * @param <T>
     * @return
     */
    public static <T> ResultModel<T> buildResponseModel(T result) {
        ResultModel response = new ResultModel();
        response.setCode(HttpStatus.OK.value());
        response.setStatus(HttpStatus.OK.getReasonPhrase());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        response.setResult(result);
        return response;
    }
}
