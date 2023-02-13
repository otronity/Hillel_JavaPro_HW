package com.example.springdata.controller;

import com.example.springdata.dto.OrderDto;
import com.example.springdata.dto.OrderProductsDto;
import com.example.springdata.model.Order;
import com.example.springdata.model.OrderProducts;
import com.example.springdata.repository.OrderProductsRepository;
import com.example.springdata.repository.OrderRepository;
import com.example.springdata.repository.ProductRepository;
import com.example.springdata.service.OrderProductsService;
import com.example.springdata.service.OrderService;
import com.example.springdata.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/orders")
public class WebController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderProductsRepository orderProductsRepository;
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderProductsService orderProductsService;

    @GetMapping("/findall")
    public List<Order> findAll(){
        log.info("Get all orders");
        return (List) orderRepository.findAll();
    }

    @GetMapping("/orderbyid/{id}")
    public Order getOrdersById(@PathVariable Integer id){
        Order order = orderRepository.getOrderById(id);
        log.info("Order Id = {}", order);
        return order;
    }

    @GetMapping("/addorder/{products}")
    public OrderDto addOrder(@PathVariable String products){
        String[] prod = products.split(",");
        Double orderCost = 0d;
        for (String s : prod) {
            orderCost += productRepository.getProductsById(Integer.parseInt(s)).getCost();
        }
        OrderDto orderDtoRec = new OrderDto(null, LocalDateTime.now(), orderCost);
        orderService.createOrder(orderDtoRec);
        for (String s : prod) {
            OrderProductsDto opDtoRec = new OrderProductsDto(orderDtoRec.getId(), Integer.parseInt(s));
            orderProductsService.createOrderProducts(opDtoRec);
        }
        log.info("Created Order = {}", orderDtoRec);
        return orderDtoRec;
    }

    @GetMapping("/delorderbyid/{id}")
    public String delOrder(@PathVariable Integer id){
        Order order = getOrdersById(id);
        List<OrderProducts> opList = orderProductsRepository.getOrderProductsByOrderid(id);
        orderProductsService.deleteOrderProducts(opList);
        orderService.deleteOrder(order);
        log.info("Order deleted");
        return "Order deleted";
    }
}
