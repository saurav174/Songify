package com.superHyperCars.controller;


import com.superHyperCars.dto.RequestDTO;
import com.superHyperCars.dto.ResponseDTO;
import com.superHyperCars.dto.SignUpReqDTO;
import com.superHyperCars.manager.SignUpManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/init")
public class SignUpController {

    private Logger logger = LoggerFactory.getLogger(SignUpController.class);

    @Autowired
    private SignUpManager signUpManager;

    @RequestMapping("/sign_up")
    public ResponseDTO signUp(@RequestBody RequestDTO<SignUpReqDTO> requestDTO, HttpServletResponse response) {
        ResponseDTO responseDTO = SignUpReqDTO.isValid(requestDTO.getPayload());
        if (responseDTO != null) {
            logger.info("following error occurred : {}", responseDTO.getMsg());
            return responseDTO;
        }
        responseDTO = signUpManager.signUpProcess(requestDTO);
        return responseDTO;
    }


}
