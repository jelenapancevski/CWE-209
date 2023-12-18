package com.rbs.cwe209.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
    @GetMapping("/home")
    public String home(Model model) {
        return "/home";
    }

}