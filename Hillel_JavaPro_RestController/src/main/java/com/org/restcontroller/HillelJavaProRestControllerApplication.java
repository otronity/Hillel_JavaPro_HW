package com.org.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HillelJavaProRestControllerApplication {



    public static void main(String[] args) {
        SpringApplication.run(HillelJavaProRestControllerApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void setOrders(){

    }

}
