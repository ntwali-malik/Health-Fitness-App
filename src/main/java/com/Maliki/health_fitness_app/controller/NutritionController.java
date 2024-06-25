package com.Maliki.health_fitness_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Maliki.health_fitness_app.models.Nutrition;
import com.Maliki.health_fitness_app.models.User;
import com.Maliki.health_fitness_app.services.NutritionService;
import com.Maliki.health_fitness_app.services.UserService;

@Controller
public class NutritionController {

	@Autowired
    private NutritionService nutritionService;
    @Autowired
    private UserService userService;
    
    @GetMapping("/nutritions")
    public String getNutritions(Model model) {
        model.addAttribute("nutritions", nutritionService.getAllNutritions());
        return "nutrition-list";
    }
    
    @GetMapping("/nutritions/user/{userId}")
    public String getNutritionsByUser(@PathVariable Long userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute("nutritions", nutritionService.getNutritionByUser(user));
        return "nutrition-list";
    }
    
    @GetMapping("/nutritions/new")
    public String createNutritionForm(Model model) {
        model.addAttribute("nutrition", new Nutrition());
        model.addAttribute("users", userService.getAllUsers());
        return "nutrition-form";
    }
    
    @PostMapping("/nutritions")
    public String saveNutrition(@ModelAttribute Nutrition nutrition) {
        nutritionService.saveNutrition(nutrition);
        return "redirect:/nutritions";
    }

}
