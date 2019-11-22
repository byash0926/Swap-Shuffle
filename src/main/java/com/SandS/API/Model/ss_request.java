package com.SandS.API.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@ToString
@Table(name = "ss_request",schema = "ss")
public class ss_request implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "P_ID")
    @JsonBackReference(value = "request_product")
    private ss_product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "U_ID")
    @JsonBackReference(value = "user_request")
    private ss_users user;

    @Column(name="DATETIME")

    private Date datetime;

}

