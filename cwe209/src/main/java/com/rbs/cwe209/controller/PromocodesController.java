package com.rbs.cwe209.controller;

import com.rbs.cwe209.model.Promocode;
import com.rbs.cwe209.repository.ProductRepository;
import com.rbs.cwe209.repository.PromocodeRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class PromocodesController {
    PromocodeRepository promocodeRepository;
    PromocodesController (PromocodeRepository promocodeRepository){
        this.promocodeRepository=promocodeRepository;
    }

    @GetMapping("/promocode")
    public String getPromocode(@RequestParam String promoCode, Model model) {
        Promocode promocode = promocodeRepository.findPromocode(promoCode);
        if(promocode!=null){
            model.addAttribute("promocode",promocode);
        }
        else {
            model.addAttribute("errorMessage", "Promocode doesn't exist");
        }
        return "/basket";
    }
}
