package com.tutorial.Shoppy.Product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository){
        return args -> {
            product test1 = new product("cbrowne9472@gmail.com", "Phone", "New IPHONE 14 PRO");
            product test2 = new product("KIm@gmail.com", "CAR", "Supra");

            repository.saveAll(List.of(test1, test2));
        };
    }

}
