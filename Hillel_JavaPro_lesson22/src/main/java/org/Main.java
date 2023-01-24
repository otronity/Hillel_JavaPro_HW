package org;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String configPath = "src/main/resources/ApplicationContext.xml";
        ApplicationContext context = new FileSystemXmlApplicationContext(configPath);

        Product product1 = context.getBean("product1", Product.class);
        Product product2 = context.getBean("product2", Product.class);
        Product product3 = context.getBean("product3", Product.class);

        ProductRepository prodRep = context.getBean("productrepository", ProductRepository.class);
        Cart cart = context.getBean("cart", Cart.class);
        Cart cart1 = context.getBean("cart", Cart.class);

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
