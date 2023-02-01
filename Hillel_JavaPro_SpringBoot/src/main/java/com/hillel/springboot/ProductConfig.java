package com.hillel.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    public Product product1() {return new Product("Milk", 30d);}

    @Bean
    public Product product2() {return new Product("Cookies", 90d);}

    @Bean
    public Product product3() {return new Product("Bread", 20d);}

    @Bean
    public ProductRepository prodRep(){
        List<Product> productList = new ArrayList<>();
        productList.add(product1());
        productList.add(product2());
        productList.add(product3());
        return new ProductRepository(productList);
    }

    @Bean
    @Scope("prototype")
    public Cart cart(){return new Cart(new ArrayList<Product>());}


}
