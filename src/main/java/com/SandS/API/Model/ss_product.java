package com.SandS.API.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@ToString
@Table(name = "ss_product",schema = "ss")
public class ss_product implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="P_ID")
    private int p_id;

    @Column(name="P_NAME")
    private String p_name;

    @Column(name="P_DESC")
    private String p_desc;

    @Column(name="P_PRICE")
    private double p_price;

    @Column(name="P_STATUS")
    private boolean p_status;

    @Column(name="P_DATETIME")
    @CreationTimestamp
    private Timestamp p_datetime;

    @ManyToOne
    @JoinColumn(name = "c_id")
    @JsonManagedReference(value = "category_product")
    @JsonIgnore
    private ss_category category;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "U_ID")
    @JsonManagedReference(value = "user_product")
    @JsonIgnore
    private ss_users user1;

    @JsonManagedReference(value = "order_product")
    @OneToOne(mappedBy = "product", targetEntity = ss_orders.class, fetch = FetchType.LAZY)
    private ss_orders order;

    @JsonManagedReference(value = "request_product")
    @OneToMany(mappedBy = "product", targetEntity = ss_request.class, fetch = FetchType.LAZY)
    private List<ss_request> requestList;

    public int getP_id() {
        return p_id;
    }
    public ss_users getUser1() {
        return user1;
    }


    public ss_product(){}

    public ss_product(String pname, String desc, double price, boolean status,ss_category category){
        this.p_name = pname;
        this.p_desc = desc;
        this.p_price = price;
        this.p_status = status;
//        this.p_datetime = date;
        this.category = category;
    }

    public void setUser(ss_users user) {
        this.user1 = user;
    }
}
