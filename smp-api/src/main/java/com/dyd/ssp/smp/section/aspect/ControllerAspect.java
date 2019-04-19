package com.dyd.ssp.smp.section.aspect;

import com.dyd.ssp.smp.section.annotation.ParamXssPass;
import com.dyd.ssp.smp.section.annotation.ValidationParam;
import com.dyd.ssp.smp.section.aspect.handler.AspectApi;
import com.dyd.ssp.smp.section.aspect.handler.AspectApiBase;
import com.dyd.ssp.smp.section.aspect.specific.ParamXssPassAspect;
import com.dyd.ssp.smp.section.aspect.specific.ValidationParamAspect;
import com.dyd.ssp.smp.util.ComUtil;
import com.dyd.ssp.smp.util.StringUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * 为切面 controller 方法切面
 */
@Aspect
@Configuration
public class ControllerAspect {

    @Pointcut("execution(* com.dyd.ssp.smp.controller..*(..))  ")
    public void aspect() {
    }

    @Around(value = "aspect()")
    public Object validationPoint(ProceedingJoinPoint pjp)throws Throwable{
        Method method = currentMethod(pjp,pjp.getSignature().getName());
        //创建被装饰者
        AspectApi  aspectApi = new AspectApiBase();
        if (!ComUtil.isEmpty(StringUtil.getMethodAnnotationOne(method, ValidationParam.class.getSimpleName()))) {
            aspectApi = new ValidationParamAspect(aspectApi);
        }else {

        }
//        //是否需要限流
//        if (method.isAnnotationPresent(AccessLimit.class)) {
//            new AccessLimitAspect(aspectApi).doHandlerAspect(pjp,method);
//        }
        //是否需要拦截xss攻击
        if(method.isAnnotationPresent( ParamXssPass.class )){
           new ParamXssPassAspect(aspectApi).doHandlerAspect(pjp,method);
        }
//        //是否需要记录日志
//        if(method.isAnnotationPresent(Log.class)){
//            return new RecordLogAspect(aspectApi).doHandlerAspect(pjp,method);
//        }
        aspectApi.doHandlerAspect(pjp,method);
        return  pjp.proceed(pjp.getArgs());
    }

    /**
     * 获取目标类的所有方法，找到当前要执行的方法
     */
    private Method currentMethod (ProceedingJoinPoint joinPoint , String methodName ) {
        Method[] methods      = joinPoint.getTarget().getClass().getMethods();
        Method   resultMethod = null;
        for ( Method method : methods ) {
            if ( method.getName().equals( methodName ) ) {
                resultMethod = method;
                break;
            }
        }
        return resultMethod;
    }



}
