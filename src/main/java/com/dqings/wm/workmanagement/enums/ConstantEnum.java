package com.dqings.wm.workmanagement.enums;

/**
 * @auther: dongqing
 * @date: 2019/8/30 15:35
 * @description:
 */
public enum ConstantEnum {
    USER("user");
    private String code;
    private ConstantEnum(String code){
        this.code=code;
    }

    public String getCode() {
        return code;
    }
}
