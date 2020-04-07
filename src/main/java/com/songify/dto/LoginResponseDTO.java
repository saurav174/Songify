package com.songify.dto;

import java.math.BigInteger;

public class LoginResponseDTO extends CommonResponseDTO {

    String Name;

    String userId;

    String email;

    BigInteger id;



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }


}
