package com.rbs.cwe209.controller;

import com.rbs.cwe209.repository.QuestionRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class QuestionsController {
    QuestionRepository questionRepository;
    public QuestionsController(QuestionRepository questionRepository) {

        this.questionRepository = questionRepository;
    }
    @PostMapping("/send")
    public String sendQuestion(Model model, @RequestParam(name = "email") String email, @RequestParam(name = "question") String question, HttpSession session) {
        String message = this.questionRepository.insert(email,question);
        session.setAttribute("message",message);
        return "contactus";
    }
}