package com.rbs.cwe209.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Controller
public class LogsController {

    @GetMapping("/logs")
    public String showLogs(Model model) {
        List<String> logs = readLogs();
        model.addAttribute("logs", logs);
        return "logs";
    }

    private List<String> readLogs() {
        try {
            Path logFilePath = Path.of("application.log");
            return Files.readAllLines(logFilePath);
        } catch (IOException e) {
            // Handle the exception (e.g., log an error)
            e.printStackTrace();
            return List.of("Error reading logs");
        }
    }
}
