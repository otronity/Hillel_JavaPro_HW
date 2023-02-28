package com.example.springsecurity.dto;

import com.example.springsecurity.api.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

    private Integer id;
    private String name;
    private UserRole userRole;
    private String password;

}
