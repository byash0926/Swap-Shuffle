package com.SandS.API.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@ToString
@Table(name= "ss_users")
public class ss_users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int U_ID;

    private String U_NAME;
    private int PHONE_NO;
    private String EMAIL_ID;
    private String PASSWORD;
    private String  PRO_PIC;
    private String U_STATUS;

    public ss_users(){}
    public ss_users(String uname, int phno, String emailId, String password,String propic,String status){
        this.U_NAME = uname;
        this.EMAIL_ID = emailId;
        this.PHONE_NO = phno;
        this.PASSWORD = password;
        this.PRO_PIC = propic;
        this.U_STATUS = status;
    }
}
