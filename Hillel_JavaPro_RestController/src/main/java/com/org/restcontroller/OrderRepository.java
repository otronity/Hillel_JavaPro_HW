package com.org.restcontroller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class OrderRepository {

    private List<Order> orders;

    public void addOrder(Order order){
        orders.add(order);
    }

    public Order getOrderById(int orderId){
        Order order = orders.stream().filter(o -> orderId == o.getId()).findAny().get();
        return order;
    }

    public List<Order> getAllOrders(){
        return orders;
    }
}
