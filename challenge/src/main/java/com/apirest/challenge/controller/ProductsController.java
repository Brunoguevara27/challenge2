package com.apirest.challenge.controller;

import com.apirest.challenge.dto.ProductsDto;
import com.apirest.challenge.service.IProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final Logger logger = LoggerFactory.getLogger(ProductsController.class);

    @Autowired
    private IProductsService productsService;


    // Este método retorna todos los productos de la tabla "products"
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public List<ProductsDto> productsAll(){
        return productsService.findAll();
    }

    // Método para guardar un producto
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save")
    public ResponseEntity<ProductsDto> guardarProduct(@Valid @RequestBody ProductsDto productsDTO) {
        return new ResponseEntity<>(productsService.save(productsDTO),HttpStatus.CREATED);
    }

    // Método para actualizar producto
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductsDto> update(@Valid @RequestBody ProductsDto productsDto,@PathVariable(name = "id") Integer id) {
        ProductsDto productoRespuesta = productsService.update(productsDto, id);
        return new ResponseEntity<>(productoRespuesta, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteProducts(@Valid @PathVariable(name = "id") Integer id) {
        productsService.delete(id);
        return new ResponseEntity<>("Publicacion eliminada con exito", HttpStatus.OK);
    }

}
