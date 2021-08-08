package com.javavilnius10.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "invoice")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDate dateOfInvoice;
    private Double vat = 0.21; //*0.21
    private Double priceTotal;
    private String pdfUrl;

    @OneToMany(mappedBy = "invoice")
    @JsonIgnore
    private List<SalesLine>salesLineList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;


}