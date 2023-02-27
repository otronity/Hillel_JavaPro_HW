package com.org.hibernate2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class ClientInfoDto {

    private Integer id;
    private String name;
    private String email;
    private String phone;
    private AddressDto addressDto;
}
