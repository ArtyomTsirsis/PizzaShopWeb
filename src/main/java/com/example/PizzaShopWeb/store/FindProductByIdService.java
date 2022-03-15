package com.example.PizzaShopWeb.store;

import com.example.PizzaShopWeb.dto.Converter;
import com.example.PizzaShopWeb.dto.ProductDto;
import com.example.PizzaShopWeb.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindProductByIdService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Converter converter;

    public List<ProductDto> find(Long id) {
        return productRepository.findById(id).map(converter::convertToDto).stream().toList();
    }

}
