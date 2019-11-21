package com.SandS.API.Model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@ToString
@Table(name = "ss_orders",schema = "ss")
public class ss_orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="O_ID")
    private int o_id;
    @JoinColumn(name = "P_ID", referencedColumnName = "P_ID")
    private int p_id;
    @JoinColumn(name = "U_ID", referencedColumnName = "U_ID")
    private int u_id;
    @Column(name="FINAL_PRICE")
    private int final_price;
    @Column(name="DATETIME")
    private Date datetime;

    public ss_orders(){}
    public ss_orders(int pid,int uid,int fprice,Date date){
        this.p_id = pid;
        this.u_id = uid;
        this.final_price = fprice;
        this.datetime = date;
    }
}
