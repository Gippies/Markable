package com.gippies.markable.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String successfulLogin() {
        return "hello";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/logout")
    public String logout() {
        return "login";
    }
}
