package org;

import java.util.List;

public class ProductRepository {

    public List<Product> products;

    public ProductRepository(List<Product> products) {
        this.products = products;
    }

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
