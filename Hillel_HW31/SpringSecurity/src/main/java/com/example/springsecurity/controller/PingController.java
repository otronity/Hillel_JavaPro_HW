package com.example.springsecurity.controller;

import com.example.springsecurity.dto.UserDto;
import com.example.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("ping")
@RequiredArgsConstructor
@Slf4j
public class PingController {

    @GetMapping
    public String ping() {
        log.info("PING");
        return "Ok";
    }

}
