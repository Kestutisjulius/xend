package com.javavilnius10.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Setter
@Getter
@ToString
public class SalesLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDateTime nowDateTime = LocalDateTime.now();
    private Double quantityOfProduct;

    @ManyToOne
    private Invoice invoice;


    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;


    public SalesLine(String name, Double quantityOfProduct) {
        this.name = name;
        this.quantityOfProduct = quantityOfProduct;
    }

    public LocalDateTime setDateNow() {return nowDateTime;}
    public void setDateNow(String dataTime) {
        this.nowDateTime = LocalDateTime.parse(dataTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public SalesLine() {
    }

}