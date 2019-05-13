package com.dyd.ssp.smp.controller;

import com.dyd.ssp.smp.base.BusinessException;
import com.dyd.ssp.smp.enums.SceneTempType;
import com.dyd.ssp.smp.section.advice.handler.ResultModel;
import com.dyd.ssp.smp.section.advice.handler.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zwt
 * @Version 1.0
 */
@Controller
@RequestMapping("/smp/common")
public class CommonController {

    @RequestMapping(value = "/needLogin",method = RequestMethod.GET)
    @ApiOperation(value = "没有登录")
    @ResponseBody
    public ResultModel needLogin(){
        return ResultUtil.unauthorizedFailure("登录过期,请重新登录");
    }


    @RequestMapping(value = "/{sceneTempType}/test",method = RequestMethod.GET)
    @ApiOperation(value = "测试自动注入枚举")
    @ResponseBody
    public ResultModel test(@PathVariable("sceneTempType") Integer sceneTempTypeCode) throws BusinessException {
        SceneTempType sceneTempType = SceneTempType.getByName(sceneTempTypeCode);
        return ResultUtil.buildResponseModel(sceneTempType.getCode()+sceneTempType.getName());
    }







}
