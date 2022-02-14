package com.apirest.challenge.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;

public class ProductsDto {

    @Getter @Setter
    private Integer id;

    @Column(length = 11, nullable = false)
    @NotNull(message = "El campo SKU no puede ser nulo")
    @Getter @Setter
    private BigInteger sku;

    @Column(length = 11, nullable = false)
    @NotNull(message = "El campo code no puede ser nulo")
    @Getter @Setter
    private Integer code;

    @Column(length = 40, nullable = false)
    @NotEmpty(message = "El campo name no puede ser nulo")
    @Getter @Setter
    private String name;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private String picture;

    @Column(length = 10, nullable = false)
    @NotNull(message = "El campo price no puede ser nulo")
    @Getter @Setter
    private double price;

    @Getter @Setter
    @Column(length = 3)
    @Size(max = 3, message = "Espacio del campo currency: varchar (3)")
    private String currency;

    public ProductsDto() {
    }

    public ProductsDto(Integer id, BigInteger sku, Integer code, String name, String description, String picture, double price, String currency) {
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
