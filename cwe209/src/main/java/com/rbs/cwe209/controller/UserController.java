package com.rbs.cwe209.controller;
import com.rbs.cwe209.model.Employee;
import com.rbs.cwe209.model.User;
import com.rbs.cwe209.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    public UserController(UserRepository userRepository) {

        this.userRepository = userRepository;
    }
    UserRepository userRepository;
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
    @GetMapping({"/home","/"})
    public String home(HttpServletResponse response)
    {
        response.addHeader("FLAG_LOGS","/logs");
        return "/home";
    }
    @GetMapping("/users")
    public String users(Model model) {
        List<User>users= userRepository.getUsers();
        model.addAttribute("users",users);

        return "users";
    }

    @GetMapping("/employees")
    public String employees(Model model) {
        List<Employee> employees= userRepository.getEmployees();
        model.addAttribute("employees",employees);

        return "employees";
    }
}