package com.Maliki.health_fitness_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Maliki.health_fitness_app.models.User;
import com.Maliki.health_fitness_app.models.Workout;
import com.Maliki.health_fitness_app.services.UserService;
import com.Maliki.health_fitness_app.services.WorkoutService;

@Controller
public class WorkoutController {

	@Autowired
    private WorkoutService workoutService;
    @Autowired
    private UserService userService;
    
    @GetMapping("/workouts")
    public String getWorkouts(Model model) {
        model.addAttribute("workouts", workoutService.getAllWorkouts());
        return "workout-list";
    }
    
    @GetMapping("/workouts/user/{userId}")
    public String getWorkoutsByUser(@PathVariable Long userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute("workouts", workoutService.getWorkoutsByUser(user));
        return "workout-list";
    }
    
    @GetMapping("/workouts/new")
    public String createWorkoutForm(Model model) {
        model.addAttribute("workout", new Workout());
        model.addAttribute("users", userService.getAllUsers());
        return "workout-form";
    }

    @PostMapping("/workouts")
    public String saveWorkout(@ModelAttribute Workout workout) {
        workoutService.saveWorkout(workout);
        return "redirect:/workouts";
    }
}
