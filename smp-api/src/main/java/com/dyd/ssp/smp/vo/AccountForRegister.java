package com.dyd.ssp.smp.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: zwt
 * @Version 1.0
 */
@Data
@ApiModel(value="商户注册实体类",description = "无")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountForRegister {
    @ApiModelProperty(hidden = true)
    private String id;
    @ApiModelProperty(value = "邀请码",example = "987654",required = true)
    private String invitationCode;
    @ApiModelProperty(value = "手机号",example = "18899996666",required = true)
    private String mobile;
    @ApiModelProperty(value = "短信验证码",example = "654321",required = true)
    private String smsCode;
    @ApiModelProperty(value = "密码",example = "md5(123456)",required = true)
    private String password;
    @ApiModelProperty(value = "微信unionId 28位",example = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx==",required = true)
    private String unionId;
}
