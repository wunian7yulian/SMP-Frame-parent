package com.dyd.ssp.smp.controller;


import com.alibaba.fastjson.JSONObject;
import com.dyd.ssp.smp.aspect.ResultModel;
import com.dyd.ssp.smp.aspect.ResultUtil;
import com.dyd.ssp.smp.mapper.UserMapper;
import com.dyd.ssp.smp.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author zwt
 * @since 2019-04-17
 */
@Api(description="用户模块")
@RestController
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value="测试get获取", notes="get请求测试下就好")
    @GetMapping("/testGet")
    public String testGet(){
        int all = userMapper.selectByMap(new HashMap<>()).size();
        return "success";
    }

    @ApiOperation(value="测试post获取", notes="post请求测试",produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "requestJson", value = "{\"userName\":\"test\",\"passWord\":\"123\"}"
                    , required = true, dataType = "String",paramType="body")
    })
    @PostMapping("/testPost")
    public Map<String,String> testPost(@RequestBody JSONObject requestJson){
        Map map = new HashMap<String,String>();
        map.put("msg","success");
        return map;
    }

    @ApiOperation(value="测试post获取 controller 直接返回 rmT ", notes="post请求测试",produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "requestJson", value = "{\"userName\":\"test\",\"passWord\":\"123\"}"
                    , required = true, dataType = "String",paramType="body")
    })
    @PostMapping("/testPostRMT")
    public ResultModel<String> testPostReturnRMT(@RequestBody JSONObject requestJson){
        log.info(requestJson.toJSONString());
        return ResultUtil.buildResponseModel(requestJson.getString("passWord"));
    }

    @ApiIgnore
    @PostMapping("/test")
    public String test(){
        return "success";
    }
}

