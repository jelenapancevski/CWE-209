package com.rbs.cwe209.controller;
import com.rbs.cwe209.model.Product;
import com.rbs.cwe209.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductsController {

    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    ProductRepository productRepository;
    @GetMapping("/products")
    public String getProducts(Model model) {

        List<Product> products = productRepository.getAll();
        model.addAttribute("products",products);
        return "products";
    }
}
