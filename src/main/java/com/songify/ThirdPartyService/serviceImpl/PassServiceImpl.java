package com.songify.ThirdPartyService.serviceImpl;


import com.songify.ThirdPartyService.ServiceInterface.PassService;
import com.songify.Utility.BasicConstants;
import org.springframework.stereotype.Repository;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Repository
public class PassServiceImpl implements PassService {
    @Override
    public String encryptPassword(String passwordStr) {
        String text = passwordStr;
        String key = BasicConstants.AES_KEY;

        Key AesKey = new SecretKeySpec(key.getBytes(),"AES");
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE,AesKey);
            byte[] encrypted = cipher.doFinal(text.getBytes());
            String pass = Base64.getEncoder().encodeToString(encrypted);
            return pass;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (BadPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return null;
        }

        return null;

    }

    @Override
    public String decryptPassword(String encryptedPassword) {
        try{
            String key = BasicConstants.AES_KEY;

            Key AesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");


            cipher.init(Cipher.DECRYPT_MODE, AesKey);
            byte[] passbyte = Base64.getDecoder().decode(encryptedPassword);
            String decrypted = new String(cipher.doFinal(passbyte));
            return decrypted;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
