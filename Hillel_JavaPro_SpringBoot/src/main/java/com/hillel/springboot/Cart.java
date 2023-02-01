package com.hillel.springboot;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Cart {
    public List<Product> prodList;

    public Cart(List<Product> prodList) {
        this.prodList = prodList;
    }

    public List<Product> getProdList() {
        return prodList;
    }

    public void addProduct(ProductRepository prodRep, int id){
        prodList.add(prodRep.getProductById(id));
        printCart();
    }

    public void delProduct(ProductRepository prodRep, int id){
        prodList.remove(prodRep.getProductById(id));
    }

    public void printCart(){
        System.out.println("Вміст корзини:");
        for (Product product : prodList) {
            System.out.println("ID = " + product.getId() + " " +
                    "Name = " + product.getName() + " " +
                    "Price = " + product.getPrice());
        }
    }
}
