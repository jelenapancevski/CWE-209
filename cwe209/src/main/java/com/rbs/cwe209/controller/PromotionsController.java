package com.rbs.cwe209.controller;

import com.rbs.cwe209.model.Product;
import com.rbs.cwe209.model.Promotion;
import com.rbs.cwe209.repository.PromotionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.SQLException;
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
    @GetMapping("/promotion/{id}")
    public String getPromotion(Model model,@PathVariable Long id) /*throws SQLException*/ {

        Promotion promotion = promotionRepository.getPromotion(id);
        if(promotion==null){
            model.addAttribute("errorMessage","No product with id = "+id);
        }
        model.addAttribute("promotion",promotion);
        return "promotion";
    }
}
