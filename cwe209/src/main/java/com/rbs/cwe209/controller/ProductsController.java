package com.rbs.cwe209.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbs.cwe209.model.Order;
import com.rbs.cwe209.model.Product;
//import com.rbs.cwe209.repository.CouponRepository;
import com.rbs.cwe209.model.Promocode;
import com.rbs.cwe209.model.User;
import com.rbs.cwe209.repository.ProductRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductsController {

    public ProductsController(ProductRepository productRepository) {
//        this.couponRepository = couponRepository;
        this.productRepository = productRepository;
    }
    ProductRepository productRepository;
//    CouponRepository couponRepository;
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
    @GetMapping("/basket")
    public String getBasket(HttpSession session, Model model, HttpServletRequest request) {
        Order o = (Order) session.getAttribute("order");
        model.addAttribute("order", o);
        return "basket";
    }

    @PostMapping("/searchByIngredient")
    public String searchByIngredient(@RequestParam(name = "ingredient", defaultValue = "chocolate") String ingredient, Model model) {
        List<String> products = productRepository.getProductsWithIngredient(ingredient);
        model.addAttribute("products", products);
        return "searchResults";
    }
    @GetMapping("/searchByIngredient")
    public String showSearchForm() {
        return "searchForm";
    }

    @PostMapping("/createServerSessionOrder")
    public String testSession(@RequestParam(name = "productName", defaultValue = "")String productName,
                              @RequestParam(name="amount", defaultValue = "1") int amount,
                              @RequestParam(name="price", defaultValue = "") int price, HttpSession session,HttpServletRequest request){

        if (session.getAttribute("order") == null) {
            UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
            User user = (User) authentication.getPrincipal();
            Order o = new Order(user.getUsername());
            o.addProduct(productName, amount, price);
            session.setAttribute("order", o);
        }
        else{
            Order o =  (Order) session.getAttribute("order");
            o.addProduct(productName, amount, price);
            Promocode promocode= (Promocode) session.getAttribute("promocodeSet");
            if(promocode!=null){
                o.setTotalPrice((int)((o.getTotalPrice()*(100-promocode.getPercent()))/100));
            }
            session.setAttribute("order", o);
        }
        session.setAttribute("message","Product successfully added to the basket");
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }


}
