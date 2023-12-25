package com.rbs.cwe209.controller;

import com.rbs.cwe209.model.Promotion;
import com.rbs.cwe209.repository.PromotionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PromotionsController {
    public PromotionsController(PromotionRepository promotionRepository) {

        this.promotionRepository = promotionRepository;
    }
    PromotionRepository promotionRepository;

    @GetMapping("/promotions")
    public String getProducts(Model model) {

        List<Promotion> promotions = promotionRepository.getAll();
        model.addAttribute("promotions",promotions);
        return "promotions";
    }
}
