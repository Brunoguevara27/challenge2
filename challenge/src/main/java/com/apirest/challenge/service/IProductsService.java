package com.apirest.challenge.service;

import com.apirest.challenge.dto.ProductsDto;

import java.util.List;

public interface IProductsService {

    List<ProductsDto> findAll();

    public ProductsDto save(ProductsDto productDto);

    ProductsDto update(ProductsDto productDto, Integer id);

    ProductsDto findByCode(Integer code);

    void delete(Integer id);
}
