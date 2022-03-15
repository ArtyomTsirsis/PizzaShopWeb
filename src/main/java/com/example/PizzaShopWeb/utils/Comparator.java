package com.example.PizzaShopWeb.utils;

import com.example.PizzaShopWeb.dto.ProductDto;
import com.example.PizzaShopWeb.store.FindAllProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Comparator {

    @Autowired
    private FindAllProductsService findAllProductsService;

    public boolean compare(ProductDto product) {
        return findAllProductsService.find().stream().anyMatch(o -> o.getId() == product.getId());
    }



}
