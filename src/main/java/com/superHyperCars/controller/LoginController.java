package com.superHyperCars.controller;

import com.superHyperCars.dto.*;
import com.superHyperCars.manager.LoginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/init")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginManager loginManager;

    public ResponseDTO loginUser(@RequestBody RequestDTO<UserDto> requestDTO) {
        ResponseDTO responseDTO = LoginRespDTO.isValid(requestDTO.getPayload());
        if (responseDTO != null) {
            logger.info("following error occurred : {}", responseDTO.getMsg());
            return responseDTO;
        }
        responseDTO = loginManager.loginProcess(requestDTO);
        return responseDTO;
    }

}
