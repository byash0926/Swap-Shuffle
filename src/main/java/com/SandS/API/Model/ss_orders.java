package com.SandS.API.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name="DATETIME")
    private Date datetime;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "P_ID")
    @JsonBackReference(value = "order_product")
    private ss_product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "U_ID")
    @JsonBackReference(value = "user_order")
    private ss_users user;

//    public ss_orders(){}
//    public ss_orders(int pid,int uid,int fprice,Date date){
//        this.p_id = pid;
//        this.u_id = uid;
//        this.final_price = fprice;
//        this.datetime = date;
//    }
}
