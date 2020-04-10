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
    public static final String REGISTRATION_FAILED_EMAIL_EXISTS = "User Registration failed email is already used!";
    public static final String OTP_GENERATION_FAILED = "Otp generation failed email doesn't exist!";
    public static final String PASSWORD_RESET_SUBJECT = "Password Reset Otp";
    public static final String OTP_UPDATE_FAILED = "OTP Update failed";
    public static final String OTP_SEND_SUCCESS_MSG = "OTP Sent Sucessfully to the registered email id";

    public static final String SUCCESS = "100";
    public static final String TRANSACTION_NOT_FOUND = "300";
    public static final String DUPLICATE_ORDER_ID = "301";
    public static final String MERCHANT_ID_REQUIRED = "302";
    public static final String ACCOUNT_NUMBER_WITH_IFSC_CODE_OR_UPI_REQUIRED = "303";
    public static final String WALLET_NOT_APPROVED = "304";
    public static final String INSUFFICIENT_BALANCE = "305";
    public static final String INVALID_STORE_ID = "306";
    public static final String INVALID_BHARATPE_TXN_ID = "307";
    public static final String INVALID_DATA = "308";
    public static final String CLIENT_NOT_FOUND = "309";
    public static final String INVALID_PARENT_ID = "310";
    public static final String INVALID_REMITTANCE_TYPE = "311";
    public static final String FAILURE_FROM_BANK = "312";
    public static final String INVALID_VPA = "313";
    public static final String REFUND_AMT_GREATER_THAN_TXN_AMT = "314";
    public static final String COMPLETED_TRANSACTION = "315";
    public static final String UNAUTHORIZED = "401";
    public static final String NOT_FOUND = "404";
    public static final String SOMETHING_WENT_WRONG = "501";
    public static final String BAD_REQUEST = "400";
}
