package com.example.demo.Models;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userid;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String account;
    @Column
    private String password;

    public long getuserid() {
        return userid;
    }
    public void setuserid(long userid) {
        this.userid = userid;
    }
    public String getusername() {
        return username;
    }
    public void setusername(String username) {
        this.username = username;
    }
    public String getemail() {
        return email;
    }
    public void setemail(String email) {
        this.email = email;
    }
    public String getaccount() {
        return account;
    }
    public void setaccount(String account) {
        this.account = account;
    }
    public String getpassword() {
        return password;
    }
    public void setpassword(String password) {
        this.password = password;
    }


}
