package com.dyd.ssp.smp.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author zwt
 * @since 2019-04-18
 */
@TableName("user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键
     */
    @TableId("id")
    private Integer id;

    /**
     * 是电话号码，也是账号（登录用）
     */
    private String mobile;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 密码
     */
    private String passWord;

    /**
     * 单位
     */
    private String unit;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 状态值（1：启用，2：禁用，3：删除）
     */
    private Integer status;

    /**
     * 职位
     */
    private String job;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", mobile=" + mobile +
        ", userName=" + userName +
        ", passWord=" + passWord +
        ", unit=" + unit +
        ", createTime=" + createTime +
        ", avatar=" + avatar +
        ", status=" + status +
        ", job=" + job +
        "}";
    }
}
