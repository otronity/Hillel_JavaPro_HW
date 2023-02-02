package com.org.restcontroller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class OrderConfig {

    @Bean
    public Product product1() {return new Product(1, "Milk", 30l);}

    @Bean
    public Product product2() {return new Product(2, "Cookies", 90l);}

    @Bean
    public Product product3() {return new Product(3, "Bread", 20l);}


    @Bean
    public Order order1(){
        List<Product> productList = new ArrayList<>();
        productList.add(product1());
        productList.add(product2());
        productList.add(product3());
        return new Order( productList);
    }

    @Bean
    public Order order2(){
        List<Product> productList = new ArrayList<>();
        productList.add(product2());
        productList.add(product3());
        return new Order(productList);
    }

    @Bean
    public Order order3(){
        List<Product> productList = new ArrayList<>();
        productList.add(product1());
        productList.add(product3());
        return new Order(productList);
    }

    @Bean
    public OrderRepository orderRep(){
        List<Order> orderList = new ArrayList<>();
        orderList.add(order1());
        orderList.add(order2());
        orderList.add(order3());
        return new OrderRepository(orderList);
    }

}
