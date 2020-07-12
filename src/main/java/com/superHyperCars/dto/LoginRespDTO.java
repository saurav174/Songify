package com.superHyperCars.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.superHyperCars.constants.Constants;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class LoginRespDTO {

    private String appUserId;

    private String accessToken;

    private String webClientId;

    public String getWebClientId() {
        return webClientId;
    }

    public void setWebClientId(String webClientId) {
        this.webClientId = webClientId;
    }

    public String getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(String appUserId) {
        this.appUserId = appUserId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public static ResponseDTO isValid(UserDto userDto) {

        ResponseDTO responseDTO = new ResponseDTO();
        if (userDto.getPassword() == null || userDto.getUserName() == null) {
            responseDTO.setMsg(Constants.SOMETHING_WENT_WRONG);
            return responseDTO;
        }
        return null;

    }
}
