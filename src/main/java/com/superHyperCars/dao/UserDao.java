package com.songify.dao;

import com.songify.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;


public interface UserDao extends CrudRepository<User, BigInteger> {


    @Query("Select u from User u where userId=:userId and password=:Password")
    User findByUserIDAAndPassword(String userId,String Password);

    @Query("Select count(1) from User u where userId=:userId")
    int countUserWithUserId(String userId);

    @Query("Select count(1) from User u where email=:Email")
    int countUserWithEMailId(String Email);

    @Query("Select u from User u where email=:Email")
    User findUserByEmail(String Email);

}
