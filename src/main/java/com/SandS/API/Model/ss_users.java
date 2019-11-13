package com.SandS.API.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
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
    private String u_status;

    public ss_users(){}
    public ss_users(String uname, int phno, String emailId, String password,String propic,String status){
        this.u_name = uname;
        this.email = emailId;
        this.phone_no = phno;
        this.password = password;
        this.pro_pic = propic;
        this.u_status = status;
    }

    public ss_users(String email){
        this.email = email;
    }
    public ss_users(String email,String password){
        this.email = email;
        this.password = password;
    }
}
