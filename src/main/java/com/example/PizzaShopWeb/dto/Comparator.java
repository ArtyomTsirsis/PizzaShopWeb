package com.example.PizzaShopWeb.dto;

import com.example.PizzaShopWeb.products.Product;
import com.example.PizzaShopWeb.store.FindAllProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.InstanceAlreadyExistsException;

@Component
public class Comparator {

    @Autowired
    private FindAllProductsService findAllProductsService;

    public boolean compare(ProductDto product) {
        return findAllProductsService.findAll().stream().anyMatch(o -> o.getName().equals(product.getName()));
    }



}
