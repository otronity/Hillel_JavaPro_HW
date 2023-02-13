package com.example.springdata;

import com.example.springdata.repository.ProductRepository;
import com.example.springdata.service.OrderService;
import com.example.springdata.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import java.awt.desktop.AppReopenedEvent;


@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onInit(){
        log.info("App ready");
    }
}
