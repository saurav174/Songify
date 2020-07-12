package com.superHyperCars.manager;

import com.superHyperCars.entities.Verify;
import com.superHyperCars.enums.CommonEnum;
import com.superHyperCars.constants.Constants;
import com.superHyperCars.dao.UserDao;
import com.superHyperCars.dao.VerifyDao;
import com.superHyperCars.dto.LoginRespDTO;
import com.superHyperCars.dto.RequestDTO;
import com.superHyperCars.dto.ResponseDTO;
import com.superHyperCars.dto.UserDto;
import com.superHyperCars.entities.AppUser;
import com.superHyperCars.entities.User;
import com.superHyperCars.service.AppUserService;
import com.superHyperCars.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class LoginManager {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private VerifyDao verifyDao;

    private Logger logger = LoggerFactory.getLogger(LoginManager.class);

    public ResponseDTO loginProcess(RequestDTO<UserDto> requestDTO) {

        logger.info("login process started for request : {}", requestDTO);
        UserDto userDto = requestDTO.getPayload();
        String deviceType = requestDTO.getMetaDTO().getDeviceType();
        String deviceId = requestDTO.getMetaDTO().getDeviceId();
        String userName = userDto.getUserName();
        String password = userDto.getPassword();
        ResponseDTO<LoginRespDTO> responseDTO = new ResponseDTO<LoginRespDTO>();
        LoginRespDTO loginRespDTO = new LoginRespDTO();
        Date loginTimeStamp = new Date();

        try {
            List<User> users = userDao.findByUserNameAndPassword(userName, password);
            if (users == null || users.isEmpty()) {
                logger.info("invalid username or password for username : {}", userName);
                responseDTO.setMsg(Constants.LOGIN_FAILED_INCORRECT_USERNAME_PASSWORD);
                return responseDTO;
            }

            User user = users.get(0);
            AppUser appUser = user.getAppUser();
            if (appUser == null) {
                logger.info("creating new app user for the username : {}", userName);
                appUser = appUserService.createAppUser(user, userName, loginTimeStamp);
                user.setAppUser(appUser);
                userDao.save(user);
            }

            Verify verify = new Verify();
            String webClientId = null;
            String currentTimsStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(loginTimeStamp);
            String accessToken = null;

            if (deviceType.equals(CommonEnum.clientType.WEB_BROWSER.toString())) {
                if (deviceId == null) {
                    verify.setAppUser(appUser);
                    webClientId = CommonUtils.getUniqueKey();
                    accessToken = webClientId + currentTimsStamp;
                    verify.setAccessToken(accessToken);
                    verify.setDeviceId(webClientId);
                    verify.setDeviceType(deviceType);
                } else {
                    verify = verifyDao.findByDeviceTypeAndDeviceId(deviceType, deviceId);
                    if (verify == null) {
                        logger.error("Error occurred no device found ");
                        responseDTO.setSuccess(false);
                        responseDTO.setMsg(Constants.SOMETHING_WENT_WRONG);
                        return responseDTO;
                    }
                    verify.setAppUser(appUser);
                    verifyDao.save(verify);
                }
            } else {
                if (deviceId == null) {
                    logger.error("device id can't be empty for mobile user username : {}", userName);
                    responseDTO.setSuccess(false);
                    responseDTO.setMsg(Constants.SOMETHING_WENT_WRONG);
                    return responseDTO;
                }

                verify = verifyDao.findByDeviceTypeAndDeviceId(deviceType, deviceId);
                if (verify == null) {
                    verify.setAppUser(appUser);
                    verify.setDeviceId(deviceId);
                    verify.setDeviceType(deviceType);
                    accessToken = deviceId + currentTimsStamp;
                    verify.setAccessToken(accessToken);
                }
                verify.setAppUser(appUser);
                verifyDao.save(verify);
            }
            loginRespDTO.setAccessToken(accessToken);
            loginRespDTO.setAppUserId(String.valueOf(appUser.getId()));
            loginRespDTO.setWebClientId(webClientId);
            responseDTO.setMsg(Constants.LOGIN_SUCCESS);
            responseDTO.setDate(loginRespDTO);

        } catch (Exception ex) {
            logger.error("Exception occurred for login user : {},{}", userName, ex);
            responseDTO.setSuccess(false);
            responseDTO.setMsg(Constants.SOMETHING_WENT_WRONG);
        }
        return responseDTO;
    }

}
