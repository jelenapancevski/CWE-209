package com.rbs.cwe209.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HiddenFlagInHttpResponseController {
    @PostMapping("/hiddenInHeader")
    public String hideFlagResponse(HttpServletResponse response) {
        String secretFlag = "<<Flag_3>>";
        response.addHeader("HIDDEN_FLAG", secretFlag);
        return "home"; // Redirect to the same page
    }
}
