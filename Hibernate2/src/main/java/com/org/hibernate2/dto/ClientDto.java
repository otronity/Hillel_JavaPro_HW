package com.org.hibernate2.dto;

import com.org.hibernate2.model.Address;
import com.org.hibernate2.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private Integer id;
    private String name;
    private String email;
    private String phone;

}
