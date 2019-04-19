package com.dyd.ssp.smp.section.advice;

import com.dyd.ssp.smp.section.advice.handler.ResultModel;
import com.dyd.ssp.smp.section.advice.handler.ResultUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;

/**
 *  Rest 返回 数据结构统一
 *
 * @Author: zwt
 * @Version 1.0
 */
@ControllerAdvice(annotations = RestController.class)
public class RestResponseBodyAdvice implements ResponseBodyAdvice {

    private static final Class[] annos = {
            RequestMapping.class,
            GetMapping.class,
            PostMapping.class,
            DeleteMapping.class,
            PutMapping.class
    };

    public RestResponseBodyAdvice() {
    }

    /**
     * 对所有RestController的接口方法进行拦截
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        AnnotatedElement element = returnType.getAnnotatedElement();
        return Arrays.stream(annos).anyMatch(anno -> anno.isAnnotation() && element.isAnnotationPresent(anno));
    }

    @Override
    public Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        Object out = null;

        if(body instanceof ResultModel){
            out = body;
        } else {
            out =  ResultUtil.buildResponseModel(body);
        }
        return out;
    }

}
