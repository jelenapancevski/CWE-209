package com.rbs.cwe209.controller;
import com.rbs.cwe209.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
    @Autowired
   UserService userService;
    @GetMapping("/login")
    public String login(Model model) {
        //if(model.getAttribute("username")!=null) return "redirect:/";
        return "login";
    }

    @PostMapping("/login")
    public String checklogin(String username, String password, Model model) {
      /* String pass= userService.findByUsername(username);
       if(pass==null) model.addAttribute("message","Ne postoji dato korisničko ime");
       else if(password.equals(pass)){
           model.addAttribute("username",username);
           return "redirect:/";
       }
       else {
           model.addAttribute("message","Pogrešna lozinka za korisničko ime "+ username);
          /* console.log("Username: "+username);
           console.log("Entered password: "+password);
           console.log("Password: "+pass);*/
    /*   }*/
       return "login";
    }
    @GetMapping("/home")
    public String home(Model model) {
        //if(model.getAttribute("username")==null) return "redirect:/login";
        return "/home";
    }
}