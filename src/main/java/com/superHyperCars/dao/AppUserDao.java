package com.superHyperCars.dao;

import com.superHyperCars.entities.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserDao extends CrudRepository<AppUser,Long> {


}
