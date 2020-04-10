package com.songify.handlers;


import com.songify.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EmailHandler {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private RestTemplate restTemplate;

    public void sendOtpEmail(String otp,String to,String userId)
    {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(Constants.PASSWORD_RESET_SUBJECT);
        simpleMailMessage.setText("Your OTP to reset your Password for "+userId+" is "+otp);
        javaMailSender.send(simpleMailMessage);
    }

}
