package com.example.springdata.service;

import com.example.springdata.dto.OrderProductsDto;
import com.example.springdata.model.Order;
import com.example.springdata.model.OrderProducts;
import com.example.springdata.repository.OrderProductsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderProductsService {

    @Autowired
    private final OrderProductsRepository opRerository;
    private final ObjectMapper objectMapper;

    public OrderProductsDto createOrderProducts(OrderProductsDto orderProductsDto){
        OrderProducts orderProducts = objectMapper.convertValue(orderProductsDto, OrderProducts.class);
        opRerository.save(orderProducts);
        return orderProductsDto;
    }

    public void deleteOrderProducts(List<OrderProducts> orderRecs){
        for (OrderProducts orderRec : orderRecs) {
            opRerository.delete(orderRec);
        }
    }

}
