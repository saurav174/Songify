package com.songify.entities;

import javax.persistence.*;

@Entity
@Table(name = "verify")
public class Verify extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_table_id")
    private User user;

    @Column(name = "token")
    private String token;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
