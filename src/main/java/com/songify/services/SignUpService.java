package com.songify.services;


import com.songify.constants.Constants;
import com.songify.dao.UserDao;
import com.songify.dto.CommonResponseDTO;
import com.songify.entities.User;
import com.songify.utils.EmailUtility;
import com.songify.utils.PasswordUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SignUpService {

    @Autowired
    UserDao userDao;

    public CommonResponseDTO SignUp(Map requestBody)
    {
        CommonResponseDTO commonResponseDTO = new CommonResponseDTO();
        User user = new User();
        String userId = requestBody.get("userId").toString();
        int userCount = userDao.countUserWithUserId(userId);
        if(userCount>=1)
        {
            commonResponseDTO.setSuccess(false);
            commonResponseDTO.setMsg(Constants.REGISTRATION_FAILED_USER_EXIST);
            return commonResponseDTO;
        }
        user.setUserId(userId);
        String name = requestBody.get("name").toString();
        user.setName(name);
        String password = requestBody.get("password").toString();
        if (!PasswordUtility.isvalidPassword(password))
        {
            commonResponseDTO.setSuccess(false);
            commonResponseDTO.setMsg(Constants.REGISTRATION_FAILED_PASSWORD_INVALID);
            return commonResponseDTO;
        }
        user.setPassword(password);
        String email = requestBody.get("email").toString();

        if (email!=null || !email.isEmpty())
        {
            if (!EmailUtility.isValid(email))
            {
                commonResponseDTO.setSuccess(false);
                commonResponseDTO.setMsg(Constants.REGISTRATION_FAILED_EMAIL_INVALID);
                return commonResponseDTO;
            }
        }
        user.setEmail(email);
        userDao.save(user);
        commonResponseDTO.setSuccess(true);
        commonResponseDTO.setMsg(Constants.REGISTRATION_SUCCESSFUL);
        return  commonResponseDTO;
    }

}
