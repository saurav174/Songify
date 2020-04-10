package com.songify.dao;

import com.songify.entities.Verify;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface VerifyDao  extends CrudRepository<Verify, BigInteger> {

    @Query("select v from Verify v where token=:token")
    Verify fetchDetailsFromToken(String token);

}
