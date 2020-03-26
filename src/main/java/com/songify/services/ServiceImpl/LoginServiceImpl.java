package com.songify.services.ServiceImpl;

import com.songify.Dao.Interface.LoginDao;
import com.songify.Repository.ResponseMessageWithResponseObject;
import com.songify.Utility.BasicUtils;
import com.songify.entities.User;
import com.songify.services.ServiceInterface.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceImpl implements LoginService {


    @Autowired
    LoginDao loginDao;

    @Override
    public Object validateUser(Object userId, Object userPassword) {
        Object user = null;
        ResponseMessageWithResponseObject responseObject = new ResponseMessageWithResponseObject();
        if(BasicUtils.isEmpty(userId) || BasicUtils.isEmpty(userPassword))
        {
            responseObject.setReturnedObject(null);
            responseObject.setMessage("Please Enter Username and Password");
            responseObject.setType("failure");
            responseObject.setStatus(false);
        }
        else
        {
            user = loginDao.getUserWithUserId(userId,userPassword);
            if(!BasicUtils.isEmpty(user))
            {
                responseObject.setReturnedObject(user);
                responseObject.setMessage("Login Successfull");
                responseObject.setMessage("Success");
                responseObject.setStatus(true);
            }
            else
            {
                responseObject.setReturnedObject(null);
                responseObject.setMessage("Login failed");
                responseObject.setMessage("Success");
                responseObject.setStatus(false);
            }
        }
        return responseObject;
    }

    @Override
    public Object saveLoginDetails(Object userId) {
        return null;
    }

    @Override
    public Object checkUserExistence(Object useremail) {
        return null;
    }

    @Override
    public Object saveResetPasswordDetails(User user, Object Password) {
        return null;
    }
}
