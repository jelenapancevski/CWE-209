package com.rbs.cwe209.controller;

import com.rbs.cwe209.model.Location;
import com.rbs.cwe209.repository.LocationRepository;
import com.rbs.cwe209.repository.QuestionRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuestionsController {
    QuestionRepository questionRepository;
    LocationRepository locationRepository;
    public QuestionsController(QuestionRepository questionRepository, LocationRepository locationRepository) {
        this.locationRepository=locationRepository;
        this.questionRepository = questionRepository;
    }
    @PostMapping("/send")
    public String sendQuestion(Model model, @RequestParam(name = "email") String email, @RequestParam(name = "question") String question, HttpSession session) {
        String message = this.questionRepository.insert(email,question);
        session.setAttribute("message",message);
        return "redirect:contactus";
    }

    @GetMapping("/contactus")
    public String questionsPage(Model model){
        List<Location> locations = locationRepository.findOpen();
        model.addAttribute("locations",locations);
        return "contactus";
    }
}
