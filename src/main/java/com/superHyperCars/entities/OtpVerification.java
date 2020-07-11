package com.songify.entities;


import javax.persistence.*;

@Entity
@Table(name = "otp_verification")
public class OtpVerification extends BaseEntity{

    @OneToOne
    @JoinColumn(name = "user_table_id")
    private User user;

    @Column(name = "otp")
    private String otp;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }


}
