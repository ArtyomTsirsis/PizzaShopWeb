package com.example.PizzaShopWeb.store;

import com.example.PizzaShopWeb.dto.Comparator;
import com.example.PizzaShopWeb.dto.Converter;
import com.example.PizzaShopWeb.dto.ProductDto;
import com.example.PizzaShopWeb.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Comparator comparator;
    @Autowired
    private Converter converter;

    public void update(ProductDto product) {
        if(comparator.compare(product)) {
            productRepository.updateProduct(converter.convertFromDto(product));
        }
    }

}
