package com.songify.controllers;


import com.songify.dto.CommonResponseDTO;
import com.songify.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SignUpController {


    @Autowired
    SignUpService signUpService;


    @RequestMapping("/api/signup")
    public CommonResponseDTO userSignUp(@RequestBody Map requestMap)
    {
        CommonResponseDTO commonResponseDTO = signUpService.SignUp(requestMap);
        return  commonResponseDTO;
    }


}
