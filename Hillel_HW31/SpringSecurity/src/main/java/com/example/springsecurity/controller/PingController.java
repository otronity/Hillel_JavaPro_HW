package com.example.springsecurity.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PingController {

    @GetMapping
    public String ping() {
        log.info("PING");
        return "Ok";
    }

}
