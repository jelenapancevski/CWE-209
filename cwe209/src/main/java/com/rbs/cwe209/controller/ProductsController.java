package com.rbs.cwe209.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductsController {
    @GetMapping("/products")
    public String login(Model model) {
        return "products";
    }
}
