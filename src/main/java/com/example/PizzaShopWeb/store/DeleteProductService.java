package com.example.PizzaShopWeb.store;

import com.example.PizzaShopWeb.utils.Comparator;
import com.example.PizzaShopWeb.dto.Converter;
import com.example.PizzaShopWeb.dto.ProductDto;
import com.example.PizzaShopWeb.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Comparator comparator;
    @Autowired
    private Converter converter;

    public void delete(ProductDto product) {
        if (comparator.compare(product)) {
            productRepository.delete(converter.convertFromDto(product));
        }
    }

}
