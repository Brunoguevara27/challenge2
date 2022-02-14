package com.apirest.challenge.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "products")
@ToString
public class Products {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;

    @Column(length = 11, nullable = false)
    @Getter @Setter
    private BigInteger sku;

    @Column(length = 11, nullable = false)
    @Getter @Setter
    private Integer code;

    @Column(length = 40, nullable = false)
    @Getter @Setter
    private String name;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private String picture;

    @Column(length = 10, nullable = false)
    @Getter @Setter
    private double price;

    @Getter @Setter
    @Column(length = 3)
    private String currency;


    public Products() {
    }

    public Products(BigInteger sku, Integer code, String name, String description, String picture, double price, String currency) {
        this.sku = sku;
        this.code = code;
        this.name = name;
        this.description = description;
        this.picture = picture;
        this.price = price;
        this.currency = currency;
    }

    public Products(Integer id, BigInteger sku, Integer code, String name, String description, String picture, double price, String currency) {
        this.id = id;
        this.sku = sku;
        this.code = code;
        this.name = name;
        this.description = description;
        this.picture = picture;
        this.price = price;
        this.currency = currency;
    }
}