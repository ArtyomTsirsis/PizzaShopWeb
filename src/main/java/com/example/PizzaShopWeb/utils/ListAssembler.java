package com.example.PizzaShopWeb.utils;

import com.example.PizzaShopWeb.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListAssembler {

    public List<ProductDto> assemble(List<ProductDto> listOne, List<ProductDto> listTwo) {
        List<ProductDto> products = new ArrayList<>();
        products.addAll(listOne);
        products.addAll(listTwo);
        return products;
    }

}
