package com.example.springdata.service;

import com.example.springdata.dto.OrderDto;
import com.example.springdata.model.Order;
import com.example.springdata.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;
    private final ObjectMapper objectMapper;
    public OrderDto createOrder(OrderDto orderDto){
        Order order = objectMapper.convertValue(orderDto, Order.class);
        orderRepository.save(order);
        orderDto.setId(order.getId());
        return orderDto;
    }

    public void deleteOrder(Order order){
        orderRepository.delete(order);
    }

}
