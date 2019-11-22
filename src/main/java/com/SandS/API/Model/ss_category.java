package com.SandS.API.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

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
    private String name;

    public List<ss_product> getProductList() {
        return productList;
    }

    @OneToMany(mappedBy = "category", targetEntity = ss_product.class, fetch = FetchType.LAZY)
    @JsonBackReference(value = "category_product")
    private List<ss_product> productList;

    public ss_category(){}
    public ss_category(String cname){
        this.name = cname;
    }
}
