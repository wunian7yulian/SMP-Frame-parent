package com.dyd.ssp.smp.exception;

/**
 * 参数异常
 */
public class ParamJsonException extends RuntimeException{

    private static final long serialVersionUID = 5159179859025026224L;
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public ParamJsonException() {}

    public ParamJsonException(String message) {
        super(message);
        this.message = message;
    }


}
