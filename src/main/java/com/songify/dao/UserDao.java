package com.songify.dao;

import com.songify.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface UserDao extends CrudRepository<User,String> {


    @Query("Select u from User u where userId=:userId and password=:Password")
    User findByUserIDAAndPassword(String userId,String Password);

    @Query("Select count(userId) from User u where userId=:userId")
    int countUserWithUserId(String userId);

}
