package com.SandS.API.Model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@ToString
@Table(name = "ss_product")
public class ss_product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int P_ID;

    private String P_NAME;

    private int C_ID;
    private int U_ID;
    private String P_IMAGES;
    private String P_DESC;
    private int P_PRICE;
    private String P_STATUS;
    private Date P_DATETIME;

    public ss_product(){}
    public ss_product(String pname,int cid,int uid, String images,String desc,int price,String status,Date date){
        this.P_NAME = pname;
        this.C_ID = cid;
        this.U_ID = uid;
        this.P_IMAGES = images;
        this.P_DESC = desc;
        this.P_PRICE = price;
        this.P_STATUS = status;
        this.P_DATETIME = date;

    }
}
