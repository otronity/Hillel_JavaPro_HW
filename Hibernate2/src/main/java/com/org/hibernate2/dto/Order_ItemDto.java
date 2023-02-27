package com.org.hibernate2.dto;

import com.org.hibernate2.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order_ItemDto {
    private Integer id;
    private Order order;
    private ProductDto product;
    private Integer count;
}
