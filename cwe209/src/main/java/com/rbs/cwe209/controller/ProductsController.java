package com.rbs.cwe209.controller;
import com.rbs.cwe209.model.Product;
import com.rbs.cwe209.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    @GetMapping("/product/{id}")
    public String getProducts(Model model,@PathVariable Long id) {

        Product product = productRepository.getProduct(id);
        model.addAttribute("product",product);
        return "product";
    }
}
