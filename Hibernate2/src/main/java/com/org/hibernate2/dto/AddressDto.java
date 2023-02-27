package com.org.hibernate2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    private Integer id;
    private ClientDto client;
    private String country;
    private String  city;
    private String street;
    private String house;
}
