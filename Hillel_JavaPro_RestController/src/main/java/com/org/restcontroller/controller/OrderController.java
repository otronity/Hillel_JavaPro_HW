package com.org.restcontroller.controller;

import com.org.restcontroller.Order;
import com.org.restcontroller.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRep;

    @GetMapping("/allorders")
    public List<Order> readOrders(){
        return orderRep.getAllOrders();
    }

    @GetMapping("/orderbyid/{id}")
    public Order readOrders(@PathVariable int id){
        return orderRep.getOrderById(id);
    }
}


