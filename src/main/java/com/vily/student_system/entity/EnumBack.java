package com.vily.student_system.entity;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019-04-03
 *  
 **/

public enum EnumBack {
    SERVE_EXCEPTION(1,"服务器繁忙，请稍后再试"),

    RESULT_WRONG(2001, "失败"),
    RESULT_PHONE_WRONG(2002, "用户名已存在"),
    RESULT_PSW_WRONG(2003, "密码错误"),
    RESULT_ROLE_WRONG(2004, "角色名称已经存在"),
    PARTER_EMPTY(2005,"参数不能为空" ),
    User_empty(2006, "用户不存在，请检查用户名是否正确"),
    Number_empty(2007, "学号错误，请检查学号是否正确");

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    EnumBack(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }}
