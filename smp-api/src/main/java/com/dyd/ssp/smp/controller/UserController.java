package com.dyd.ssp.smp.controller;


import com.dyd.ssp.smp.section.advice.handler.ResultModel;
import com.dyd.ssp.smp.section.advice.handler.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zwt
 * @since 2019-05-06
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/needLogin",method = RequestMethod.GET)
    @ApiOperation(value = "没有登录")
    @ResponseBody
    public ResultModel needLogin(){
        return ResultUtil.unauthorizedFailure("登录过期,请重新登录");
    }
}

