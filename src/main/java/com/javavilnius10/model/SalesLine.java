package com.javavilnius10.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "sales_line")
@Entity
@Setter
@Getter
@ToString
public class SalesLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDateTime nowDateTime;
    private Double quantityOfProduct;


    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;

    public SalesLine(String name, LocalDateTime nowDateTime, Double quantityOfProduct, User user, Product product) {
        this.name = name;
        this.nowDateTime = nowDateTime;
        this.quantityOfProduct = quantityOfProduct;
        this.user = user;
        this.product = product;
    }

    public SalesLine() {
    }
}