package com.example.logger;

import com.example.logger.orders.CoffeeOrderBoard;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@Data
public class LoggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoggerApplication.class, args);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void start(){
        CoffeeOrderBoard cob = new CoffeeOrderBoard();

        cob.add("Olga");
        cob.add("Dmitro");
        cob.add("Oleg");
        cob.add("Daria");
        cob.add("Ivan");

        cob.draw();
        cob.deliver();
        cob.draw();

        cob.deliver(10);
        cob.draw();

        cob.deliver();
        cob.draw();
    }
}
