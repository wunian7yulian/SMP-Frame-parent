package com.dyd.ssp.smp.controller;

import com.dyd.ssp.smp.base.BusinessException;
import com.dyd.ssp.smp.config.security.anno.CurrentUser;
import com.dyd.ssp.smp.entity.User;
import com.dyd.ssp.smp.enums.SceneTempType;
import com.dyd.ssp.smp.section.advice.handler.ResultModel;
import com.dyd.ssp.smp.section.advice.handler.ResultUtil;
import com.dyd.ssp.smp.section.annotation.ValidationParam;
import com.dyd.ssp.smp.vo.AccountForRegister;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: zwt
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/smp")
public class ApiController {


//
//
//    @ApiOperation(value="测试post获取", notes="post请求测试",produces = "application/json")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "requestJson", value = "{\"userName\":\"test\",\"passWord\":\"123\"}"
//                    , required = true, dataType = "String",paramType="body")
//    })
//    @PostMapping("/testPost")
//    public Map<String,String> testPost(@RequestBody JSONObject requestJson){
//        Map map = new HashMap<String,String>();
//        map.put("msg","success");
//        return map;
//    }
//
//    @ApiOperation(value="测试post获取 controller 直接返回 rmT ", notes="post请求测试",produces = "application/json")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "requestJson", value = "{\"userName\":\"test\",\"passWord\":\"123\"}"
//                    , required = true, dataType = "String",paramType="body")
//    })
//    @PostMapping("/testPostRMT")
//    public ResultModel<String> testPostReturnRMT(@RequestBody JSONObject requestJson){
//        log.info(requestJson.toJSONString());
//        return ResultUtil.buildResponseModel(requestJson.getString("passWord"));
//    }
//
//    @ApiIgnore
//    @PostMapping("/test")
//    public String test(){
//        return "success";
//    }
//
//
//    @ApiOperation(value="测试post获取", notes="post请求测试",produces = "application/json")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "requestJson", value = "{\"userName\":\"test\",\"passWord\":\"123\",\"job\":\"职位\"}"
//                    , required = true, dataType = "String",paramType="body")
//    })
//    @PostMapping("/testVP")
//    public Map<String,String> testVP(@ValidationParam("userName,passWord,job")@RequestBody JSONObject requestJson){
//        Map map = new HashMap<String,String>();
//        map.put("msg","success");
//        return map;
//    }


    /**
     * password
     * @return
     */
    @ApiOperation(value="注册接口", notes="商家注册",produces = "application/json")
    @PostMapping("/auth/register")
    public ResultModel<AccountForRegister> testPostReturnRMT(@RequestBody AccountForRegister accountForRegister){
//        log.info(requestJson.toJSONString());
        return ResultUtil.buildResponseModel(accountForRegister);
    }

    /**
     * password
     * @return
     */
    @ApiOperation(value="测试接口", notes="商家注册",produces = "application/json")
    @PostMapping("/auth/test")
    public ResultModel<UserDetails> test(@CurrentUser UserDetails user){
//        log.info(requestJson.toJSONString());
        return ResultUtil.buildResponseModel(user);
    }


    @ApiOperation(value="测试接口", notes="商家注册",produces = "application/json")
    @PostMapping("/auth/changeHeadimgurl")
    public ResultModel<UserDetails> test111(@CurrentUser UserDetails user){
//        log.info(requestJson.toJSONString());
        return ResultUtil.buildResponseModel(user);
    }

    @RequestMapping(value = "art/{sceneTempType}/save",method = RequestMethod.GET)
    @ApiOperation(value = "测试自动注入枚举")
    @ResponseBody
    public ResultModel test(@PathVariable("sceneTempType") Integer sceneTempTypeCode) throws BusinessException {
        SceneTempType sceneTempType = SceneTempType.getByName(sceneTempTypeCode);
        return ResultUtil.buildResponseModel(sceneTempType.getCode()+" -- "+sceneTempType.getName());
    }
}
