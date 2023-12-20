package com.rbs.cwe209.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbs.cwe209.model.Order;
import com.rbs.cwe209.model.Product;
import com.rbs.cwe209.repository.CouponRepository;
import com.rbs.cwe209.repository.ProductRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductsController {

    public ProductsController(ProductRepository productRepository, CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
        this.productRepository = productRepository;
    }
    ProductRepository productRepository;
    CouponRepository couponRepository;
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
    public String getBasket(HttpSession session, Model model) {
        Order o = (Order) session.getAttribute("order");
        model.addAttribute("order", o);
        return "basket";
    }
    @PostMapping("/sendOrder")
        public String setBasket(@RequestParam(name = "order", required = false) String orderJson, Model model, HttpSession session) {
            if (orderJson != null) {
                // If the order is present in the form submission, convert it to an object
                ObjectMapper objectMapper = new ObjectMapper();
                System.out.println(orderJson);
                Order order = null;
                try {
                    order = objectMapper.readValue(orderJson, Order.class);
                    // Add the order to the model
                    System.out.println(order);
                    model.addAttribute("order", order);

                    // Optionally, you can also save it in session if needed
                    session.setAttribute("order", order);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }


            }
            return "basket";
            // Return the name of your Thymeleaf template

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
                              @RequestParam(name="price", defaultValue = "") int price, HttpSession session){

        if (session.getAttribute("order") == null) {
            Order o = new Order("test");
            //treba dohvatiti ime trenutnog ulogovanog,
            // mada nam mozda ovo i ne treba ako necemo cuvati narudzbine u bazi
            o.addItem(productName, amount, price);
            session.setAttribute("order", o);
        }
        else{
            Order o =  (Order) session.getAttribute("order");
            o.addItem(productName, amount, price);
            session.setAttribute("order", o);
        }
        return "redirect:/products";
    }

    @PostMapping("/applyCoupon")
    public String applyCoupon(@RequestParam(name = "couponCode", defaultValue = "") String couponCode
            , HttpSession session){
        int discount = couponRepository.getCouponDiscount(couponCode);
        if(discount == -1){
            //greska
            return"redirect:/basket?badCoupon=true";
        }
        else{
            //dobar jetreba smanjiti cenu ukupnu
            return"redirect:/basket";
        }
    }
}
