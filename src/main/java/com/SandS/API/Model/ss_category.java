package com.SandS.API.Model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
@Table(name="ss_category", schema = "ss")
public class ss_category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="C_ID")
    private int c_id;
    @Column(name="C_NAME")
    private String c_name;

    public ss_category(){}
    public ss_category(String cname){
        this.c_name = cname;
    }
}
