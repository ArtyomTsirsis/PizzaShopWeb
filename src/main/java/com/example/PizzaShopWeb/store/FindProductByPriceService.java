package com.example.PizzaShopWeb.store;

import com.example.PizzaShopWeb.dto.Converter;
import com.example.PizzaShopWeb.dto.ProductDto;
import com.example.PizzaShopWeb.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.StreamSupport;

@Component
public class FindProductByPriceService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Converter converter;

    public List<ProductDto> find(double price) {
        return StreamSupport.stream(productRepository.findAllByPrice(price).spliterator(), false).
                map(converter::convertToDto).toList();
    }

}
