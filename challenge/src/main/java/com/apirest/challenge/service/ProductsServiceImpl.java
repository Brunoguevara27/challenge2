package com.apirest.challenge.service;

import com.apirest.challenge.dto.ProductsDto;
import com.apirest.challenge.exceptions.ResourceNotFoundException;
import com.apirest.challenge.model.Products;
import com.apirest.challenge.repository.IProductsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductsServiceImpl implements IProductsService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IProductsRepository productsRepository;


    @Override
    public List<ProductsDto> findAll() {
        return productsRepository.findAll().stream().map(this::mapearDTO).collect(Collectors.toList());
    }

    @Override
    public ProductsDto save(ProductsDto productDto) {
        Products products = mapearEntidad(productDto);

        Products nuevProducts = productsRepository.save(products);

        ProductsDto productRespuesta = mapearDTO(nuevProducts);
        return productRespuesta;
    }


    @Override
    public ProductsDto update(ProductsDto productsDto, Integer id) {
        Optional<Products> products = productsRepository.findById(id);

        products.get().setCode(productsDto.getCode());
        products.get().setCurrency(productsDto.getCurrency());
        products.get().setDescription(productsDto.getDescription());
        products.get().setPrice(productsDto.getPrice());
        products.get().setName(productsDto.getName());
        products.get().setSku(productsDto.getSku());
        products.get().setPicture(productsDto.getPicture());

        Products productsActualizado = productsRepository.save(products.get());
        return mapearDTO(productsActualizado);
    }

    @Override
    public ProductsDto findByCode(Integer code) {
        Products publicacion = productsRepository.findById(code)
                .orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", code));
        return mapearDTO(publicacion);
    }

    @Override
    public void delete(Integer id) {
        Products products = productsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", id));
        productsRepository.delete(products);
    }

    // Convierte entidad a DTO
    private ProductsDto mapearDTO(Products products) {
        ProductsDto productsDto = modelMapper.map(products, ProductsDto.class);
        return productsDto;
    }

    // Convierte de DTO a Entidad
    private Products mapearEntidad(ProductsDto productsDto) {
        Products products = modelMapper.map(productsDto, Products.class);
        return products;
    }
}
