package com.org.hibernate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private Integer id;
    private String name;
    private String email;
    private List<MarkDto> marks;
}
