package com.vily.student_system.service;


import com.vily.student_system.entity.EnumBack;
import com.vily.student_system.entity.ResultV;
import com.vily.student_system.entity.User;
import com.vily.student_system.repositories.UserRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019-04-03
 *  
 **/

@Service
public class RedisService {

    @Resource
    private UserRepositery mUserRepositery;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    // 写入 redis
    public Object testRedis() {

        //字符串序列化格式 一般是key值字符串 value值不需要改动
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);

        User user = new User();
        user.setUserName("sadasd");

        redisTemplate.opsForValue().set("user",user);

        return null;
    }

    // 读取redis
    public Object getRedis() {

        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);

        User user = (User) redisTemplate.opsForValue().get("user");

        return user;
    }
}
