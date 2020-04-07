package com.songify.constants;

import org.springframework.stereotype.Component;

@Component
public class Constants {

    public static final String LOGIN_SUCCESS = "User found with the following credentials, Login Successful";
    public static final String REGISTRATION_SUCCESSFUL = "User Registration Successful";
    public static final String REGISTRATION_FAILED_USER_EXIST = "User Registration failed user with userId already exists!";
    public static final String REGISTRATION_FAILED_PASSWORD_INVALID = "User Registration failed password is invalid!";
    public static final String REGISTRATION_FAILED_EMAIL_INVALID = "User Registration failed email is invalid!";
    public static final String AUTHENTICATION_FAILED = "User Authentication failed userId or Password is invalid!";
}
