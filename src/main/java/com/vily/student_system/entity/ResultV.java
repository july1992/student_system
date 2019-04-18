package com.vily.student_system.entity;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019-04-03
 *  
 **/

public class ResultV {

    private int code;

    private Object data;

    private String message;

    public ResultV() {
    }

    public ResultV(int code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public ResultV(int code, String message) {
        this.code = code;
        this.message = message;

    }

    public ResultV(Object data) {
        this.data = 200;
        this.message="成功";
        this.data=data;
    }

    public static ResultV ok( ){
        return new ResultV(null);
    }
    public static ResultV ok(Object data ){
        return new ResultV(data);
    }
    public static ResultV error(EnumBack enumBack){

        return new ResultV(enumBack.getCode(),null,enumBack.getMsg());

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
