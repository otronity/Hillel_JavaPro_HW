package com.example.logger.orders;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
@Slf4j
public class CoffeeOrderBoard {

    private int orderNum = 0;
    List<Order> orderList = new ArrayList<>();

    public void add(String name) {
        log.info("Add order");
        orderNum++;
        Order order = new Order(name, orderNum);
        orderList.add(order);
        log.info("{} N{} {}", "Order", order.getOrderNum(), "is received!");
    }

    public void deliver() {
        log.info("Deliver oldest order");
        try {
            if (!orderList.isEmpty()) {
                Order min = orderList.stream().min(Order::compare).get();
                log.info("{} N{} {}", "Order", orderList.get(0).getOrderNum(), "is delivered!");
                orderList.remove(min);
            } else {
                throw new Exception("list of orders isEmpty!");
            }
        } catch (Exception ex) {
            log.error("Exception", ex);
        }
    }

    public void deliver(Integer orderNum) {
        log.info("Delivering order by id");
        try {
            if (orderList.stream().filter(order -> orderNum.equals(order.getOrderNum()))
                    .findAny().isPresent()) {
                orderList.remove(orderList.stream().filter(
                        order -> orderNum.equals(order.getOrderNum())).findAny().get());
            } else {
                log.info("Замовлення з таким номером не існує");
            }
        } catch (Exception ex) {
            log.error("Exception", ex);
        }
    }

    public void draw() {

        if(!orderList.isEmpty()) {
            log.info("Draw OrderBoard");
            for (Order order : orderList) {
                MDC.put("number", String.valueOf(order.getOrderNum()));
                MDC.put("name", order.getClientName());
                log.info("order in queue");
            }
        } else log.info("Список замовлень пустий");
    }
}
