package com.dyd.ssp.smp.enums;

import com.dyd.ssp.smp.base.BusinessException;

/**
 * @Author: zwt
 * @Version 1.0
 */
public enum SceneTempType {
    TICK(1,"打卡"),
    LINK(2,"外链");

    private Integer code;
    private String name;

    SceneTempType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static SceneTempType getByName(Integer code) throws BusinessException {
        SceneTempType result = null;
        for (SceneTempType type : SceneTempType.values()) {
            if (type.getCode().equals(code)) {
                result = type;
                break;
            }
        }
        if (result == null) throw new BusinessException("未识别的场景!");
        return result;
    }

}

