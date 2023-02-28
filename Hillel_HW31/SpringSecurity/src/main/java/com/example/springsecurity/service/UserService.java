package com.example.springsecurity.service;

import com.example.springsecurity.dto.UserDto;
import com.example.springsecurity.model.User;
import com.example.springsecurity.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    public UserDto createUser(UserDto userDto) {
        User user = objectMapper.convertValue(userDto, User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
        userDto.setId(user.getId());
        return userDto;
    }

    public boolean hasUserByName(String email) {
        return  userRepository.existsUserByName(email);
    }

}
