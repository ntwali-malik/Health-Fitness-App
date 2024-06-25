package com.Maliki.health_fitness_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import jakarta.servlet.http.HttpServletRequest;

//import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class CustomErrorController implements ErrorController {

    private final ErrorAttributes errorAttributes;

    @Autowired
    public CustomErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        // Get error attributes map
        Map<String, Object> errorAttributes = getErrorAttributes(request);

        // Add attributes to the model
        model.addAttribute("status", errorAttributes.get("status"));
        model.addAttribute("error", errorAttributes.get("error"));
        model.addAttribute("message", errorAttributes.get("message"));

        // Customize the view name based on the error status
        return "error"; // Thymeleaf template name (error.html)
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request) {
        // Use WebRequest instead of ServletWebRequest
        return this.errorAttributes.getErrorAttributes(
            new ServletWebRequest(request), 
            ErrorAttributeOptions.defaults()
        );
    }

    public String getErrorPath() {
        return "/error";
    }
}
