package com.dyd.ssp.smp.config.security.permission;


import com.dyd.ssp.smp.section.advice.handler.ResponseUtil;
import com.dyd.ssp.smp.section.advice.handler.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * 接口鉴权失败处理
 *
 * @author zwt
 * @since 2019-05-06
 */
@Component
@Slf4j
public class RestAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        ResponseUtil.out(response, ResultUtil.forbiddenRequestError("抱歉，您没有访问权限"));
    }

}
