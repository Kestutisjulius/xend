package com.javavilnius10.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String unitOfMeasurement; //mato vnt.
    private Double productQuantity;
    private Double productPrice;
    private Double productSalePrice;
    private String productType;


    @OneToMany(mappedBy = "product", orphanRemoval = true)
    @JsonIgnore
    private List<SalesLine> salesLineList;

    public Product(String productName, String unitOfMeasurement, Double productQuantity, Double productPrice, Double productSalePrice, String productType) {
        this.productName = productName;
        this.unitOfMeasurement = unitOfMeasurement;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productSalePrice = productSalePrice;
        this.productType = productType;
    }

    public Product(List<SalesLine> salesLineList) {
        this.salesLineList = salesLineList;
    }

    public Product() {
    }

}