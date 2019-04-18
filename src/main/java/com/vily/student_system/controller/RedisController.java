package com.vily.student_system.controller;

import com.vily.student_system.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019-04-17
 *  
 **/
@RestController
@RequestMapping("redis/")
public class RedisController {

    @Autowired
    RedisService testRedis;

    @GetMapping("testRedis")
    public Object testRedis(){

        return testRedis.testRedis();
    }

    @GetMapping("getRedis")
    public Object getRedis(){

        return testRedis.getRedis();
    }

}
