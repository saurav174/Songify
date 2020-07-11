package com.superHyperCars.entities;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

public class Verify extends BaseEntity {

    @ManyToMany
    @JoinColumn(name = "app_user_id")
    private Long appUserId;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "access_token")
    private String accessToken;

    public Long getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(Long appUserId) {
        this.appUserId = appUserId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
