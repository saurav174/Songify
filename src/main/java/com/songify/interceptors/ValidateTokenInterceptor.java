package com.songify.interceptors;

import com.songify.constants.Constants;
import com.songify.dao.VerifyDao;

import com.songify.entities.User;
import com.songify.entities.Verify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.Normalizer;

public class ValidateTokenInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(ValidateTokenInterceptor.class);

    @Autowired
    private VerifyDao verifyDao;


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {


        String token = request.getHeader("token");

        try {
            if (StringUtils.isEmpty(token)) {
                sendFailureResponse(response, Constants.UNAUTHORIZED);
                return false;
            }

            Verify tokenDetails = verifyDao.fetchDetailsFromToken(token);

            if (tokenDetails == null) {
                sendFailureResponse(response, Constants.UNAUTHORIZED);
                return false;
            }

           User user = tokenDetails.getUser();
            if (user != null) {
                request.setAttribute("User", user);
                return true;
            }

        } catch (Throwable th) {
            sendFailureResponse(response,Constants.UNAUTHORIZED);
        }
        sendFailureResponse(response, Constants.UNAUTHORIZED);
        return false;
    }

    private void sendFailureResponse(HttpServletResponse response, String responseCode) {
        response.setStatus(Integer.parseInt(responseCode));
    }

}
