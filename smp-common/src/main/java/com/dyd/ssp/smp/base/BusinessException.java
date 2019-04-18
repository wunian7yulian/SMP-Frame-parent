package com.dyd.ssp.smp.base;

/**
 * @author zwt
 *  统一异常
 */
public class BusinessException extends Exception{

    private static final long serialVersionUID = -688339636037377759L;

    public BusinessException(String msg){
        super(msg);
    }
}