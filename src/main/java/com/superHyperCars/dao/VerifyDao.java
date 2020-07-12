package com.superHyperCars.dao;

import com.superHyperCars.entities.Verify;
import org.springframework.data.repository.CrudRepository;

public interface VerifyDao extends CrudRepository<Verify,Long> {

    Verify findByDeviceTypeAndDeviceId(String deviceType,String deviceId);

}
