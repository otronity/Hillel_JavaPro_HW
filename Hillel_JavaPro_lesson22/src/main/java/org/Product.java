package org;

public class Product {

    private String name;
    private Double price;
    private int id;
    private static int maxId = 0;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
        maxId++;
        this.id = maxId;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }


}
