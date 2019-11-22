package com.SandS.API.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
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
    private Long phone_no;

    @Column(name = "EMAIL_ID")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column (name = "PRO_PIC")
    @Lob
    private String profiePic;

    @Column(name = "U_STATUS")
    private Boolean u_status = false;

    @OneToMany(mappedBy = "user1", targetEntity = ss_product.class, fetch = FetchType.LAZY)
    @JsonBackReference(value = "user_product")
    private List<ss_product> productList;

    @OneToMany(mappedBy = "user", targetEntity = ss_orders.class, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "user_order")
    private List<ss_orders> ordersList;

    @OneToMany(mappedBy = "user", targetEntity = ss_request.class, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "user_request")
    private List<ss_request> requestList;

    private String tokenID;

    public ss_users(){}

    public ss_users(int id){
        this.u_id = id;
    }

    public ss_users(String uname, Long phno, String emailId, String password, String pic){
        this.u_name = uname;
        this.email = emailId;
        this.phone_no = phno;
        this.password = password;
        this.profiePic = pic;

    }
    public ss_users(String uname, Long phno, String emailId, String password,String tokenID, String pic){
        this.u_name = uname;
        this.email = emailId;
        this.phone_no = phno;
        this.password = password;
        this.tokenID = tokenID;
        this.profiePic = pic;
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

    public Long getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(Long phone_no) {
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
        return profiePic;
    }

    public void setPro_pic(String pro_pic) {
        this.profiePic = pro_pic;
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

    public int getU_id() { return u_id; }
}
