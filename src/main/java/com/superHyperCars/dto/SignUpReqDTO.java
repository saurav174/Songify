package com.superHyperCars.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.superHyperCars.constants.Constants;
import com.superHyperCars.utils.EmailUtility;
import com.superHyperCars.utils.PasswordUtility;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SignUpReqDTO {

    private String userName;

    private String name;

    private String password;

    private String email;

    private String ConfirmPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ResponseDTO isValid(SignUpReqDTO signUpReqDTO) {

        ResponseDTO responseDTO = null;
        if (!signUpReqDTO.getPassword().equals(signUpReqDTO.getConfirmPassword())) {

            responseDTO = new ResponseDTO();
            responseDTO.setSuccess(false);
            responseDTO.setMsg(Constants.REGISTRATION_FAILED_PASSWORD_MISMATCH);
            return responseDTO;
        }

        if (!PasswordUtility.isValidPassword(signUpReqDTO.getPassword())) {

            responseDTO = new ResponseDTO();
            responseDTO.setSuccess(false);
            responseDTO.setMsg(Constants.REGISTRATION_FAILED_PASSWORD_INVALID);
            return responseDTO;
        }

        if (!EmailUtility.isValid(signUpReqDTO.getEmail())) {

            responseDTO = new ResponseDTO();
            responseDTO.setSuccess(false);
            responseDTO.setMsg(Constants.REGISTRATION_FAILED_EMAIL_INVALID);
            return responseDTO;
        }
        return responseDTO;
    }
}
