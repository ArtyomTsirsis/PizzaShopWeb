package com.example.PizzaShopWeb.controller;

import com.example.PizzaShopWeb.dto.ProductDto;
import com.example.PizzaShopWeb.products.Product;
import com.example.PizzaShopWeb.products.ProductName;
import com.example.PizzaShopWeb.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Optional;

@RestController
public class StoreController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = {"/optional", "/optional/{key}"})
    public String getByOptionalKey(@PathVariable(required = false) String key) {
        return Optional.ofNullable(key).orElse(ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("I_AM_A_TEAPOT \uD83E\uDED6").toString());
    }

    @GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @GetMapping(value = "/find/{key}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Product> findBy(@PathVariable(required = false) String key) {
        if (key.matches("\\d") || key.matches("\\d.\\d")) {
            return productRepository.findAllByPrice(Double.parseDouble(key));
        } else if (Arrays.stream(ProductName.values()).anyMatch(n -> n.toString().equalsIgnoreCase(key))) {
            return productRepository.findAllByName(ProductName.valueOf(key));
        } else {
            return findAll();
        }
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @DeleteMapping("/delete")
    public void deleteProduct(@RequestBody Product product) {
        productRepository.delete(product);
    }

    @PutMapping("/update")
    public void updateProduct(@RequestBody Product product) {
        productRepository.updateProduct(product);
    }

}
