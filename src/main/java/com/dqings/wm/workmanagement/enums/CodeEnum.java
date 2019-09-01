package com.dqings.wm.workmanagement.enums;

public enum CodeEnum {
    SUCCESS("0000","成功"),
    FAIL("0001","失败"),
    ERROR("9999","系统异常");
    private String code;
    private String msg;
    private CodeEnum(String code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
