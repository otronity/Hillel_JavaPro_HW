package com.hillel.springboot;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ProductRepository {

    public List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getProductById(int id){
        return products.stream().filter(product -> id == product.getId()).findAny().get();
    }

    public void printProducts(){
        for (Product product : products) {
            System.out.println("ID = " + product.getId() + " " +
                    "Name = " + product.getName() + " " +
                    "Price = " + product.getPrice());
        }
    }

}
