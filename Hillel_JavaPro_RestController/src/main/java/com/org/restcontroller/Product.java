package com.org.restcontroller;


import lombok.Getter;

//@Service
@Getter
public class Product {
    private int id;
    private String name;
    private Long cost;


    public Product(int id, String prodname, Long cost) {
        this.id = id;
        this.name = prodname;
        this.cost = cost;
    }
}
