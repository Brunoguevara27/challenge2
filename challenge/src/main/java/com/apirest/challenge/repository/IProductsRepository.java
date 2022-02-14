package com.apirest.challenge.repository;

import com.apirest.challenge.dto.ProductsDto;
import com.apirest.challenge.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductsRepository extends JpaRepository<Products,Integer> {

    public ProductsDto findByCode(Integer code);

    public Optional<Products> findById(Integer id);
}
