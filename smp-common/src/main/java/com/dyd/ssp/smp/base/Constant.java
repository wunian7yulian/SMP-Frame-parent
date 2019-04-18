package com.dyd.ssp.smp.base;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zwt
 */
public class Constant {

    public static final int BYTE_BUFFER = 1024;

    public static Set<String>  METHOD_URL_SET = new HashSet<>();

    /**
     * 用户注册默认角色
     */
    public static final int DEFAULT_REGISTER_ROLE = 5;

    public static final int BUFFER_MULTIPLE = 10;

    //验证码过期时间
    public static final Long PASS_TIME =  50000 * 60 *1000L;

    //根菜单节点
    public static final String ROOT_MENU = "0";

    //菜单类型，1：菜单  2：按钮操作
    public static final int TYPE_MENU = 1;

    //菜单类型，1：菜单  2：按钮操作
    public static final int TYPE_BUTTON = 2;

    public static boolean isPass=false;

    //启用
    public static final int ENABLE = 1;
    //禁用
    public static final int DISABLE = 0;

    public static class FilePostFix{
        public static final String ZIP_FILE =".zip";

        public static final String [] IMAGES ={"jpg", "jpeg", "JPG", "JPEG", "gif", "GIF", "bmp", "BMP", "png"};
        public static final String [] ZIP ={"ZIP","zip","rar","RAR"};
        public static final String [] VIDEO ={"mp4","MP4","mpg","mpe","mpa","m15","m1v", "mp2","rmvb"};
        public static final String [] APK ={"apk","exe"};
        public static final String [] OFFICE ={"xls","xlsx","docx","doc","ppt","pptx"};

    }
    public class FileType{
        public static final int FILE_IMG = 1;
        public static final int FILE_ZIP = 2;
        public static final int FILE_VEDIO= 3;
        public static final int FILE_APK = 4;
        public static final int FIVE_OFFICE = 5;
        public static final String FILE_IMG_DIR= "/img/";
        public static final String FILE_ZIP_DIR= "/zip/";
        public static final String FILE_VEDIO_DIR= "/video/";
        public static final String FILE_APK_DIR= "/apk/";
        public static final String FIVE_OFFICE_DIR= "/office/";
    }

    public class RoleType{
        //超级管理员
        public static final String SYS_ASMIN_ROLE= "sysadmin";
        //管理员
        public static final String ADMIN= "admin";
        //普通用户
        public static final String USER= "user";
    }

    public class ResultType{
        public static final String FAILED  = "系统错误";

        public static final String SUCCEED = "操作成功";

        public static final String UNAUTHORIZED  = "获取登录用户信息失败";

        public static final String ERROR  = "操作失败";

        public static final String DATA_ERROR  = "数据操作错误";

        public static final String PARAM_ERROR  = "参数错误";

        public static final String INVALID_USERNAME_PASSWORD  = "用户名或密码错误";

        public static final String INVALID_RE_PASSWORD  = "两次输入密码不一致";

        public static final String INVALID_USER  = "用户不存在";

        public static final String INVALID_ROLE  = "角色不存在";

        public static final String USER_NO_PERMITION  = "当前用户无该接口权限";

        public static final String VERIFY_PARAM_ERROR  = "校验码错误";

        public static final String VERIFY_PARAM_PASS  = "校验码过期";

        public static final String MOBILE_ERROR  = "手机号格式错误";

    }


}
