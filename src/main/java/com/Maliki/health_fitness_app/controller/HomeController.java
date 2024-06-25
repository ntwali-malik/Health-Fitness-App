package com.Maliki.health_fitness_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home"; // This should match the name of your Thymeleaf template (home.html)
    }
}
