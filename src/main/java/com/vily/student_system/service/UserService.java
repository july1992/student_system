package com.vily.student_system.service;


import com.vily.student_system.entity.EnumBack;
import com.vily.student_system.entity.ResultV;
import com.vily.student_system.entity.User;
import com.vily.student_system.repositories.UserRepositery;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019-04-03
 *  
 **/

@Service
public class UserService {

    @Resource
    private UserRepositery mUserRepositery;



    public ResultV regist(String userName, String psw, String number, String parentId) {


        ResultV resultV = ResultV.error(EnumBack.SERVE_EXCEPTION);


        User byUserName = mUserRepositery.findByNumber(number);
        if (byUserName != null) {
            resultV = ResultV.error(EnumBack.RESULT_PHONE_WRONG);
        } else {
            User user = new User();

            user.setPassword(psw);
            user.setUserName(userName);
            user.setNumber(number);

            User parent = mUserRepositery.findByNumber(parentId);
            if(parent!=null){
                user.setParentNode(parent);
            }

            User save = mUserRepositery.save(user);
            if (save != null) {
                resultV = ResultV.ok(save);
            }
        }

        return resultV;

    }


    public ResultV login(String number, String psw) {

        if(StringUtils.isEmpty(number) || StringUtils.isEmpty(psw)){

            return ResultV.error(EnumBack.PARTER_EMPTY);
        }

        User user = mUserRepositery.findByNumber(number);
        if(user==null){
            return ResultV.error(EnumBack.Number_empty);
        }
        if(psw.equals(user.getPassword())){

            return ResultV.ok(user);
        }else{
            return ResultV.error(EnumBack.RESULT_PSW_WRONG);
        }

    }

    public ResultV getStudents(String number, int page) {

        System.out.println("---------------");

        User parent = mUserRepositery.findByNumber(number);
        List<User> nodes = parent.getNodes();

        return ResultV.ok(nodes);

    }
}
