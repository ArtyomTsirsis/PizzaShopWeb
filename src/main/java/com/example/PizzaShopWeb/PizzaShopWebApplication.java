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

	// TODO: 08/09/2021 2. Read about POJO and more specific -> DTO
	// TODO: 08/09/2021 3. Read about mappers, i.e. mapping from DTO to entity and vice versa
	// TODO: 08/09/2021 4. Create DTO(without ID there) and modify endpoints in such way to receive ID as path variable in case of edit/delete
	// TODO: 08/09/2021 5. Create mapper(-s) to properly map data from DTO to your entity
	// TODO: 08/09/2021 6. Remove any logic from controller and leave only a call of method which implements required functionality,
	//  i.e. all logic should be held in separate class or classes and called from controller

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
