package com.gstock.msproducts.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    @Column(unique = true)
    private String sku;

    public Product(String name, BigDecimal price, String sku){
        this.name = name;
        this.price = price;
        this.sku = sku;
    }
}
