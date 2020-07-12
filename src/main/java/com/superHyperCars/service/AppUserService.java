package com.superHyperCars.service;

import com.superHyperCars.dao.AppUserDao;
import com.superHyperCars.entities.AppUser;
import com.superHyperCars.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AppUserService {

    @Autowired
    private AppUserDao appUserDao;

    public AppUser createAppUser(User user, String userName, Date loginTimestamp) {

        AppUser appUser = new AppUser();
        appUser.setUser(user);
        appUser.setLoginTimestamp(loginTimestamp);
        appUser.setUserName(userName);
       return appUserDao.save(appUser);
    }

}
