package com.example.PizzaShopWeb.controller;

import com.example.PizzaShopWeb.dto.ProductDto;
import com.example.PizzaShopWeb.products.Product;
import com.example.PizzaShopWeb.products.ProductRepository;
import com.example.PizzaShopWeb.store.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;
import java.util.Optional;

@RestController
public class StoreController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CreateProductService createProductService;
    @Autowired
    private DeleteProductService deleteProductService;
    @Autowired
    private FindAllProductsService findAllProductsService;
    @Autowired
    private FindProductByService findProductByService;
    @Autowired
    private UpdateProductService updateProductService;

    @GetMapping(value = {"/optional", "/optional/{key}"})
    public String getByOptionalKey(@PathVariable(required = false) String key) {
        return Optional.ofNullable(key).orElse(ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("I_AM_A_TEAPOT \uD83E\uDED6").toString());
    }

    @GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDto> findAll() {
        return findAllProductsService.findAll();
    }

    @GetMapping(value = "/find/{key}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDto> findBy(@PathVariable(required = false) String key) {
        return findProductByService.findBy(key);
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody ProductDto product) {
        createProductService.create(product);
    }

    @DeleteMapping("/delete")
    public void deleteProduct(@RequestBody ProductDto product) {
        deleteProductService.delete(product);
    }

    @PutMapping("/update")
    public void updateProduct(@RequestBody ProductDto product) {
        updateProductService.update(product);
    }

}
