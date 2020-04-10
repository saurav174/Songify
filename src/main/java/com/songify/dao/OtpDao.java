package com.songify.dao;

import com.songify.entities.OtpVerification;
import com.songify.entities.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.math.BigInteger;

public interface OtpDao extends CrudRepository<OtpVerification, BigInteger> {

    @Query("Select count(1) from OtpVerification ov where user=:user")
    int countUserWithUser(User user);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "UPDATE otp_verification SET otp =:otp where user_table_id=:userid")
    int updateOtpForUser(String otp,BigInteger userid);

}
