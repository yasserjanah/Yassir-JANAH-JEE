package me.janah.ecommerce;

import me.janah.ecommerce.entities.Category;
import me.janah.ecommerce.entities.Product;
import me.janah.ecommerce.repositories.CategoryRepository;
import me.janah.ecommerce.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository, CategoryRepository categoryRepository) {
        return args -> {
            Stream.of("Shirts", "Jeans", "Jackets", "Shoes", "Bags", "Accessories")
                    .forEach(categoryName -> {
                        Category category = new Category();
                        category.setName(categoryName);
                        categoryRepository.save(category);
                    });
            categoryRepository.findAll().forEach(category -> {
                    Stream.of("Computer", "Printer", "Monitor", "SmartPhone").forEach(name -> {
                        Product product = new Product();
                        product.setId(UUID.randomUUID().toString());
                        product.setName(name);
                        product.setPrice(Math.random() * 8000);
                        product.setQuantity(Math.random() * 100);
                        product.setCategory(category);
                        productRepository.save(product);
                    });
                }
            );
        };
    }

}
