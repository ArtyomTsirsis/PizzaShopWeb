package com.example.PizzaShopWeb;

import com.example.PizzaShopWeb.products.Product;
import com.example.PizzaShopWeb.products.ProductName;
import com.example.PizzaShopWeb.products.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example.PizzaShopWeb")
@SpringBootApplication
public class PizzaShopWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaShopWebApplication.class, args);
	}

	@Bean
	public CommandLineRunner productTable(ProductRepository productRepository) {
		return args -> {
			productRepository.save(new Product(ProductName.OliveOil, 1.5, 25, 0.2));
			productRepository.save(new Product(ProductName.Mozzarella, 1.2, 45, 0.15));
			productRepository.save(new Product(ProductName.Basil, 1.2, 30, 0.3));
			productRepository.save(new Product(ProductName.Dough, 2, 25, 0.2));
			productRepository.save(new Product(ProductName.TomatoSauce, 1.7, 35, 0.25));
		};
	}

}
