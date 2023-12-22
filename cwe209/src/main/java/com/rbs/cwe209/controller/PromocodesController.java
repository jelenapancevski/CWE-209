package com.rbs.cwe209.controller;

import com.rbs.cwe209.config.DatabaseAuthenticationProvider;
import com.rbs.cwe209.model.Order;
import com.rbs.cwe209.model.Promocode;
import com.rbs.cwe209.repository.ProductRepository;
import com.rbs.cwe209.repository.PromocodeRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
    public String getPromocode(@RequestParam(name="couponCode") String promoCode, HttpServletRequest request) {
        Promocode promocode = promocodeRepository.findPromocode(promoCode);
        Order order = (Order) request.getSession().getAttribute("order");
        if(promocode!=null){
           request.getSession().setAttribute("promocodeSet",promocode);
            request.getSession().removeAttribute("errorMessage");
           order.calculateTotalPrice();
           order.setTotalPrice((int)((order.getTotalPrice()*(100-promocode.getPercent()))/100));
        }
        else {
            request.getSession().removeAttribute("promocodeSet");
            request.getSession().setAttribute("errorMessage", "Promocode doesn't exist");
            order.calculateTotalPrice();
        }
        request.getSession().setAttribute("order",order);

        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }
}
