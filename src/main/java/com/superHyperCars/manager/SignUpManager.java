package com.superHyperCars.manager;


import com.superHyperCars.constants.Constants;
import com.superHyperCars.dao.UserDao;
import com.superHyperCars.dto.RequestDTO;
import com.superHyperCars.dto.ResponseDTO;
import com.superHyperCars.dto.SignUpReqDTO;
import com.superHyperCars.entities.User;
import com.superHyperCars.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignUpManager {

    private Logger logger = LoggerFactory.getLogger(SignUpManager.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    public ResponseDTO signUpProcess(RequestDTO<SignUpReqDTO> requestDTO) {

        logger.info("Sign up process started for the request : {}", requestDTO);
        SignUpReqDTO signUpReqDTO = requestDTO.getPayload();
        ResponseDTO responseDTO = new ResponseDTO();

        String name = signUpReqDTO.getName();
        String username = signUpReqDTO.getUserName();
        String password = signUpReqDTO.getPassword();
        String email = signUpReqDTO.getEmail();

        List<User> users = userDao.findByUserName(username);
        if (users != null || !users.isEmpty()) {
            logger.info("registration failed email is invalid");
            responseDTO.setSuccess(false);
            responseDTO.setMsg(Constants.REGISTRATION_FAILED_USER_EXIST);
            return responseDTO;
        }

        try {
            userService.createUser(name, username, email, password);
            responseDTO.setSuccess(true);
            responseDTO.setMsg(Constants.REGISTRATION_SUCCESSFUL);
        } catch (Exception ex) {
            logger.error("Error occurred while creating user : {}", ex);
            responseDTO.setSuccess(false);
            responseDTO.setMsg(Constants.SOMETHING_WENT_WRONG);
        }
        return responseDTO;
    }

}
