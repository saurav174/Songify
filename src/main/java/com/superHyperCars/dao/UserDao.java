package com.superHyperCars.dao;

import com.superHyperCars.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User,Long> {

    List<User> findByUserName(String userName);

}
