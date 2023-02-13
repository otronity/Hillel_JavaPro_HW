package com.example.springdata.dto;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

        private int id;
        private String name;
        private double cost;

}
