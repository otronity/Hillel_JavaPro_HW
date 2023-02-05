package com.hillel.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.Scanner;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication {
    @Autowired
    private ProductRepository prodRep;
    @Autowired
    private Cart cart;
    @Autowired
    private Cart cart_new;
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void setCart(){

        Scanner in = new Scanner(System.in);
        String input;
        boolean next = true;
        String idProduct = "";

        while (next) {
            System.out.println("Додати продукт - a, видалити продукт - d, вийти - e : ");
            input = in.next();

            if ((input.equals("a")) || (input.equals("d"))){
                System.out.println("Оберіть продукт, введіть ID:");
                prodRep.printProducts();
                idProduct = in.next();
            }

            if (input.equals("a")) {
                cart.addProduct(prodRep, Integer.parseInt(idProduct));
            }
            if (input.equals("d")) {
                cart.delProduct(prodRep, Integer.parseInt(idProduct));
            }

            if (input.equals("e")) { next = false; break;}
        }
    }
}
