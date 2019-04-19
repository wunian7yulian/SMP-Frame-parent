package com.dyd.ssp.smp.section.aspect.handler;

import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;

public abstract class AspectApiDecorator implements AspectApi{

    private AspectApi aspectApi;

    public AspectApiDecorator(AspectApi aspectApi){
        this.aspectApi=aspectApi;
    }

    public  Object doHandlerAspect(ProceedingJoinPoint pjp, Method method)throws Throwable{
        return this.aspectApi.doHandlerAspect(pjp,method);
    }

    protected abstract Object execute(ProceedingJoinPoint pjp, Method method)throws Throwable;

}
