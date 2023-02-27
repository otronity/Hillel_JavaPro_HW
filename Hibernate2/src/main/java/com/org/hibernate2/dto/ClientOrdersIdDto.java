package com.org.hibernate2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class ClientOrdersIdDto {

    private Integer id;
    private String name;
    private String email;
    private String phone;
    private List<Integer> orders;

}
