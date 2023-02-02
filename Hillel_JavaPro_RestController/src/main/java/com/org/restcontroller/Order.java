package com.org.restcontroller;

import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Getter
public class Order {

    private int id;
    private LocalDateTime date;
    private Long cost;
    private List<Product> products;
    private static int maxId = 0;

    public Order(List<Product> products) {
        maxId++;
        this.id = maxId;
        this.date = LocalDateTime.now();
        Long sumCost = 0l;
        for (Product product : products) {
            sumCost += product.getCost();
        }
        this.cost = sumCost;
        this.products = products;
    }
}
