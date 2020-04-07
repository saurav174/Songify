package com.songify.services;


import com.songify.constants.Constants;
import com.songify.dao.UserDao;
import com.songify.dto.CommonResponseDTO;
import com.songify.dto.LoginResponseDTO;
import com.songify.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserDao userDao;


     public LoginResponseDTO getUserWithUserIDPassword(String userId, String password)
    {
        User user = userDao.findByUserIDAAndPassword(userId,password);
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        if (user==null)
        {
            loginResponseDTO.setSuccess(false);
            loginResponseDTO.setMsg(Constants.AUTHENTICATION_FAILED);
            return  loginResponseDTO;
        }
        loginResponseDTO.setSuccess(true);
        loginResponseDTO.setMsg(Constants.LOGIN_SUCCESS);
        loginResponseDTO.setName(user.getName());
        loginResponseDTO.setId(user.getId());
        loginResponseDTO.setUserId(user.getUserId());
        loginResponseDTO.setEmail(user.getEmail());
        return loginResponseDTO;
    }

}
