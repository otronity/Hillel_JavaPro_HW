package com.org.hibernate2.dto;

import com.org.hibernate2.model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class ClientOrdersDto {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private AddressDto address;
    private List<OrderDto> orders;
}
