package com.vily.student_system.exception;

import com.vily.student_system.entity.EnumBack;
import com.vily.student_system.entity.ResultV;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  * description :   当接口报错的时候  会走这里
 *  * Author : Vily
 *  * Date : 2019-04-04
 *  
 **/

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResultV excption(Exception ex){

        return ResultV.error(EnumBack.SERVE_EXCEPTION);
    }
}
