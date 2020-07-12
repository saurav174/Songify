package com.superHyperCars.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "app_user")
public class AppUser extends BaseEntity{

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "login_timestamp")
    private Date loginTimestamp;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getLoginTimestamp() {
        return loginTimestamp;
    }

    public void setLoginTimestamp(Date loginTimestamp) {
        this.loginTimestamp = loginTimestamp;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
