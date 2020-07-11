package com.superHyperCars.service;

import com.superHyperCars.dao.UserDao;
import com.superHyperCars.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User createUser(String name,String userName,String email,String password) {

        User user = new User();
        user.setName(name);
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);
        return userDao.save(user);
    }

}
