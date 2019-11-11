package com.SandS.API.Model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@ToString
@Table(name = "ss_orders")
public class ss_orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int O_ID;

    private int P_ID;
    private int U_ID;
    private int FINAL_PRICE;
    private Date DATETIME;

    public ss_orders(){}
    public ss_orders(int pid,int uid,int fprice,Date date){
        this.P_ID = pid;
        this.U_ID = uid;
        this.FINAL_PRICE = fprice;
        this.DATETIME = date;
    }
}
