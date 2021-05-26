package com.example.api.enums;

public enum ResultEnum {
    SUCCESS(200, "成功"),
    FAIL(-1,"失败"),
    FAIL0(-1,"用户名或者密码错误"),
    FAIL1(-1,"用户名重复"),
    PASSWD_NULL_OR_DIFF(-2,"原密码不正确或者密码为空"),
    PARA_IS_NULL(-3,"参数为空"),
    SECRET_IS_DIFF(111,"两次输入密码不一致");
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String message) {
        this.msg = message;
    }
}
