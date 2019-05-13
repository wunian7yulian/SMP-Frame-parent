package com.dyd.ssp.smp.config.security;

import com.dyd.ssp.smp.config.security.jwt.AuthenticationFailHandler;
import com.dyd.ssp.smp.config.security.jwt.AuthenticationSuccessHandler;
import com.dyd.ssp.smp.config.security.jwt.JWTAuthenticationFilter;
import com.dyd.ssp.smp.config.security.permission.RestAccessDeniedHandler;
import com.dyd.ssp.smp.config.security.permission.MyFilterSecurityInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * Security 核心配置类
 * 开启控制权限至Controller
 * @author zwt
 * @since 2019-05-06
 */
@Slf4j
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${smp.token.redis}")
    private Boolean tokenRedis;

    @Value("${smp.tokenExpireTime}")
    private Integer tokenExpireTime;

    @Autowired
    private IgnoredUrlsProperties ignoredUrlsProperties;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthenticationSuccessHandler successHandler;

    @Autowired
    private AuthenticationFailHandler failHandler;

    @Autowired
    private RestAccessDeniedHandler accessDeniedHandler;

    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http
                .authorizeRequests();

        //除配置文件忽略路径其它所有请求都需经过认证和授权
        for(String url:ignoredUrlsProperties.getUrls()){
            registry.antMatchers(url).permitAll();
        }

        registry.and()
                //表单登录方式
                .formLogin()
                .loginPage("/smp/common/needLogin")
                //登录请求url
                .loginProcessingUrl("/smp/auth/login")
                .usernameParameter("mobile")
                .passwordParameter("password")
                .permitAll()
                //成功处理类
                .successHandler(successHandler)
                //失败
                .failureHandler(failHandler)
                .and()
                //允许网页iframe
                .headers().frameOptions().disable()
                .and()
                .logout()
                .permitAll()
                .and()
                .authorizeRequests()
                //任何请求
                .anyRequest()
                //需要身份认证
                .authenticated()
                .and()
                //关闭跨站请求防护
                .csrf().disable()
                //前后端分离采用JWT 不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //自定义权限拒绝处理类
                //添加JWT过滤器 除已配置的其它请求都需经过此过滤器
                .addFilter(new JWTAuthenticationFilter(authenticationManager(), tokenRedis, tokenExpireTime, redisTemplate))//添加自定义权限过滤器
                .addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class)
                //自定义权限拒绝处理类
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
        ;
    }
}
