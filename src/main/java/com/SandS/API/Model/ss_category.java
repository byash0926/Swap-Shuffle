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
    private int C_ID;

    private String C_NAME;

    public ss_category(){}
    public ss_category(String cname){
        this.C_NAME = cname;
    }
}
