package com.rbs.cwe209.controller;

import com.rbs.cwe209.config.DatabaseAuthenticationProvider;
import com.rbs.cwe209.model.Promocode;
import com.rbs.cwe209.repository.ProductRepository;
import com.rbs.cwe209.repository.PromocodeRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PromocodesController {


    PromocodeRepository promocodeRepository;
    PromocodesController (PromocodeRepository promocodeRepository){
        this.promocodeRepository=promocodeRepository;
    }

    @PostMapping("/promocode")
    public String getPromocode(@RequestParam(name="couponCode") String promoCode, Model model) {
        Promocode promocode = promocodeRepository.findPromocode(promoCode);
        System.out.println(promoCode);
        if(promocode!=null){
            model.addAttribute("promocode",promocode);
        }
        else {
            model.addAttribute("errorMessage", "Promocode doesn't exist");
        }
        return "redirect:/basket";
    }
}
