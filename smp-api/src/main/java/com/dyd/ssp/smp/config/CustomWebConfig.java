package com.dyd.ssp.smp.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: zwt
 * @Version 1.0
 */
@Configuration
public class CustomWebConfig implements WebMvcConfigurer {

    /**
     * 对Rest 返回 String 统一转换
     */
    @Bean
    public HttpMessageConverters customConverters(){
        return new HttpMessageConverters(new FastJsonHttpMessageConverter());
    }

}
