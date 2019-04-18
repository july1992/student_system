package com.vily.student_system.repositories;

import com.vily.student_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *  * description : 
 *  * Author : Vily
 *  * Date : 2019-04-03
 *  
 **/

public interface UserRepositery extends JpaRepository<User,String> {

    User save(User user);

    User findByUserName(String userName);

    User findByNumber(String number);

    List<User> findByNodes(User user);
}
