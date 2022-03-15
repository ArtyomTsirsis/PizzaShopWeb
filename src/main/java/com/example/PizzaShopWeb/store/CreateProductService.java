package com.example.PizzaShopWeb.store;

import com.example.PizzaShopWeb.dto.Comparator;
import com.example.PizzaShopWeb.dto.Converter;
import com.example.PizzaShopWeb.dto.ProductDto;
import com.example.PizzaShopWeb.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Converter converter;
    @Autowired
    private Comparator comparator;

    public void create(ProductDto product) {
        if (!comparator.compare(product)) {
            productRepository.save(converter.convertFromDto(product));
        }
    }

}
