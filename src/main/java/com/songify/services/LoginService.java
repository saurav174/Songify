package com.songify.services;


import com.songify.constants.Constants;
import com.songify.dao.OtpDao;
import com.songify.dao.UserDao;
import com.songify.dao.VerifyDao;
import com.songify.dto.CommonResponseDTO;
import com.songify.dto.LoginResponseDTO;
import com.songify.entities.OtpVerification;
import com.songify.entities.User;
import com.songify.entities.Verify;
import com.songify.handlers.EmailHandler;
import com.songify.utils.PasswordUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserDao userDao;

    @Autowired
    OtpDao otpDao;

    @Autowired
    VerifyDao verifyDao;

    @Autowired
    EmailHandler emailHandler;

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
        String token = PasswordUtility.generateToken(user.getUserId(),user.getId().toString());
        Verify verify = new Verify();
        verify.setUser(user);
        verify.setToken(token);
        verifyDao.save(verify);
        loginResponseDTO.setToken(token);
        loginResponseDTO.setSuccess(true);
        loginResponseDTO.setMsg(Constants.LOGIN_SUCCESS);
        loginResponseDTO.setName(user.getName());
        loginResponseDTO.setId(user.getId());
        loginResponseDTO.setUserId(user.getUserId());
        loginResponseDTO.setEmail(user.getEmail());
        return loginResponseDTO;
    }

    public CommonResponseDTO sendOtpForEmail(String email)
    {
        User user = userDao.findUserByEmail(email);
        CommonResponseDTO commonResponseDTO = new CommonResponseDTO();
        if(user == null)
        {
            commonResponseDTO.setSuccess(false);
            commonResponseDTO.setMsg(Constants.OTP_GENERATION_FAILED);
            return commonResponseDTO;
        }
        String otp = String.valueOf(PasswordUtility.generateOTP(5));
        int usercount = otpDao.countUserWithUser(user);
        if(usercount >= 1)
        {
            int success = otpDao.updateOtpForUser(otp,user.getId());
            if (success==0)
            {
                commonResponseDTO.setSuccess(false);
                commonResponseDTO.setMsg(Constants.OTP_UPDATE_FAILED);
                return commonResponseDTO;
            }
        }
        else
        {
            OtpVerification otpVerification = new OtpVerification();
            otpVerification.setOtp(otp);
            otpVerification.setUser(user);
            otpDao.save(otpVerification);
        }
        emailHandler.sendOtpEmail(otp,user.getEmail(),user.getUserId());
        commonResponseDTO.setSuccess(true);
        commonResponseDTO.setMsg(Constants.OTP_SEND_SUCCESS_MSG);
        return commonResponseDTO;
    }

}
