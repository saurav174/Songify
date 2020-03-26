package com.songify.services.ServiceInterface;

import com.songify.entities.User;

public interface LoginService {

    Object validateUser(Object userId, Object userPassword);

    Object saveLoginDetails(Object userId);

    Object checkUserExistence(Object useremail);

    Object saveResetPasswordDetails(User user, Object Password);
}
