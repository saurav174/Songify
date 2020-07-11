package com.superHyperCars.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "app_user")
public class AppUser extends BaseEntity{

    @OneToOne
    @JoinColumn(name = "user_id")
    private Long userId;

    @Column(name = "login_timestamp")
    private Date loginTimestamp;

    @Column(name = "logout_timestamp")
    private Date logoutTimestamp;


    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "device_type")
    private String deviceType;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getLoginTimestamp() {
        return loginTimestamp;
    }

    public void setLoginTimestamp(Date loginTimestamp) {
        this.loginTimestamp = loginTimestamp;
    }

    public Date getLogoutTimestamp() {
        return logoutTimestamp;
    }

    public void setLogoutTimestamp(Date logoutTimestamp) {
        this.logoutTimestamp = logoutTimestamp;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
