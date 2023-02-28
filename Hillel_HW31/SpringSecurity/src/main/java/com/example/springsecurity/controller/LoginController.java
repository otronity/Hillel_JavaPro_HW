package com.example.springsecurity.controller;


import com.example.springsecurity.api.UserRole;
import com.example.springsecurity.dto.UserDto;
import com.example.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    private final UserService userService;

    @GetMapping("index")
    public String index() {
        log.info("index page");
        return "index";
    }

    @GetMapping("login")
    public String login() {
        log.info("Login page");
        return "main/login";
    }

    @GetMapping("403")
    public String error403() {
        log.info("403 page");
        return "main/403";
    }

    @GetMapping("registration")
    public String registration() {
        log.info("registration page");
        return "main/registration";
    }

     @GetMapping("menu")
    public String menu() {
        log.info("menu page");
        return "/main/menu";
    }


    @PostMapping("registration")
    public String registration(UserDto userDto) {
        log.info("create user");
        userService.createUser(userDto);
        return "redirect:/main/login";
    }
}
