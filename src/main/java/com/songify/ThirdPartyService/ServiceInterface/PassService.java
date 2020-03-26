package com.songify.ThirdPartyService.ServiceInterface;

public interface PassService {
    String encryptPassword(String passwordStr);
    String decryptPassword(String encryptedPassword);
}
