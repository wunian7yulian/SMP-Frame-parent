package com.dyd.ssp.smp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        ParameterBuilder aParameterBuilder = new ParameterBuilder();
        aParameterBuilder
                .parameterType("header")
                .name("accessToken")
                .description("header中accessToken字段用于认证")
                .modelRef(new ModelRef("String"))
                //非必需，这里是全局配置，然而在登陆的时候是不用验证的
                .required(false).build();
        List<Parameter> aParameters = new ArrayList<Parameter>();
        aParameters.add(aParameterBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2).groupName("v1").select()
                .apis(RequestHandlerSelectors.basePackage("com.dyd.ssp.smp"))
                .paths(PathSelectors.ant("/**")).build().apiInfo(apiInfo1()).globalOperationParameters(aParameters);
    }

    private ApiInfo apiInfo1() {
        return new ApiInfoBuilder()
                .title("SMP-Frame-parent的Server端 APIs")
                .contact("ssp-smp")
                .version("v1.0.0")
                .build();
    }
//@Bean
//public Docket buildDocket() {
//    return new Docket(DocumentationType.SWAGGER_2)
//            .apiInfo(buildApiInfo())
//            .select()
//            //要扫描的API(Controller)基础包
//            .apis(RequestHandlerSelectors.basePackage("com.dyd.ssp.smp.controller"))
//            .paths(PathSelectors.any())
//            .build();
//}
//
//    /**
//     * @param
//     * @return springfox.documentation.service.ApiInfo
//     * @Title: 构建API基本信息
//     * @methodName: buildApiInfo
//     * @Description:
//     * @author: 王延飞
//     * @date: 2017-12-11  8:44
//     */
//    private ApiInfo buildApiInfo() {
//
//        return new ApiInfoBuilder()
//                .title("用户信息API文档")
//                .description("这里除了查看接口功能外，还提供了调试测试功能")
//                .contact("王延飞")
//                .version("1.0")
//                .build();
//
//    }

}
