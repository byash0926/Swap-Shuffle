package com.SandS.API.Model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@ToString
@Table(name = "ss_product",schema = "ss")
public class ss_product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="P_ID")
    private int p_id;
    @Column(name="P_NAME")
    private String p_name;
    @JoinColumn(name = "C_ID", referencedColumnName = "C_ID")
    private int c_id;
    @JoinColumn(name = "U_ID", referencedColumnName = "U_ID")
    private int u_id;
    @Column(name="P_IMAGES")
    private String p_images;
    @Column(name="P_DESC")
    private String p_desc;
    @Column(name="P_PRICE")
    private int p_price;
    @Column(name="P_STATUS")
    private String p_status;
    @Column(name="P_DATETIME")
    private Date p_datetime;

    public ss_product(){}
    public ss_product(String pname,int cid,int uid, String images,String desc,int price,String status,Date date){
        this.p_name = pname;
        this.c_id = cid;
        this.u_id = uid;
        this.p_images = images;
        this.p_desc = desc;
        this.p_price = price;
        this.p_status = status;
        this.p_datetime = date;

    }
}
