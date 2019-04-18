package com.vily.student_system.controller;

import com.vily.student_system.entity.ResultV;
import com.vily.student_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019-04-03
 *  
 **/

@RestController
@RequestMapping("user/")
public class UserController {


    @Autowired
    UserService mUserService;

    @GetMapping("regist")
    @CrossOrigin
    public ResultV regist(@RequestParam("userName")String userName,
                          @RequestParam("psw") String psw,
                          @RequestParam("number")String number,
                          @RequestParam("parentId")String parentId ){


        return mUserService.regist(userName,psw,number,parentId);
    }

    @GetMapping("login")
    @CrossOrigin
    public ResultV login(@RequestParam("number")String number, @RequestParam("psw") String psw){

        return mUserService.login(number,psw);
    }
    @GetMapping("getStudents")
    @CrossOrigin
    public ResultV getStudents(@RequestParam("number")String number, @RequestParam("page") int page){

        return mUserService.getStudents(number,page);
    }
}
