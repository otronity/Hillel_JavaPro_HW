package com.hillel.springboot;

public class Product {

    private final String name;
    private final Double price;
    private final int id;
    private static int maxId = 0;
    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
        maxId++;
        this.id = maxId;
    }
    public String getName() {
        return name;
    }
    public Double getPrice() {
        return price;
    }
    public int getId() {return id;}

}

