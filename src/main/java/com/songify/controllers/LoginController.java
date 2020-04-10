package com.songify.controllers;


import com.songify.dto.CommonResponseDTO;
import com.songify.dto.LoginResponseDTO;
import com.songify.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {


    @Autowired
    LoginService loginService;

    @RequestMapping("/api/login")
    public LoginResponseDTO userLogin(@ModelAttribute("userName") String userName, @ModelAttribute("password") String password)
    {
        LoginResponseDTO loginResponseDTO = loginService.getUserWithUserIDPassword(userName,password);
        return  loginResponseDTO;
    }

    @RequestMapping("/api/forget-password")
    public CommonResponseDTO userForgetPassword(@ModelAttribute("email") String email)
    {
        CommonResponseDTO commonResponseDTO = loginService.sendOtpForEmail(email);
        return  commonResponseDTO;
    }


}
