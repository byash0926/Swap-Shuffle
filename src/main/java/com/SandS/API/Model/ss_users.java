package com.SandS.API.Model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
//@Data
@ToString
@Table(name= "ss_users", schema = "ss")
public class ss_users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "U_ID")
    private int u_id;
    @Column(name="U_NAME")
    private String u_name;
    @Column(name = "PHONE_NO")
    private int phone_no;
    @Column(name = "EMAIL_ID")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @Column (name = "PRO_PIC")
    private String  pro_pic;
    @Column(name = "U_STATUS")
    private Boolean u_status = false;

    private String tokenID;

    public ss_users(){}
    public ss_users(String uname, int phno, String emailId, String password,String tokenID){
        this.u_name = uname;
        this.email = emailId;
        this.phone_no = phno;
        this.password = password;
        this.tokenID = tokenID;

    }

    public ss_users(String email){
        this.email = email;
    }
    public ss_users(String email,String password){
        this.email = email;
        this.password = password;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public int getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(int phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPro_pic() {
        return pro_pic;
    }

    public void setPro_pic(String pro_pic) {
        this.pro_pic = pro_pic;
    }

    public Boolean getU_status() {
        return u_status;
    }

    public void setU_status(Boolean u_status) {
        this.u_status = u_status;
    }

    public String getTokenID() {
        return tokenID;
    }

    public void setTokenID(String tokenID) {
        this.tokenID = tokenID;
    }
}
