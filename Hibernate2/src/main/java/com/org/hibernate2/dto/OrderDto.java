package com.org.hibernate2.dto;

import com.org.hibernate2.model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Integer id;
    private ClientDto client;
    private List<Order_ItemDto> orderItems;
}
