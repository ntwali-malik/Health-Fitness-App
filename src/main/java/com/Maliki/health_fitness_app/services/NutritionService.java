package com.Maliki.health_fitness_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Maliki.health_fitness_app.models.Nutrition;
import com.Maliki.health_fitness_app.models.User;
import com.Maliki.health_fitness_app.repository.NutritionRepository;

@Service
public class NutritionService {

	 	@Autowired
	    private NutritionRepository nutritionRepository;

	    public List<Nutrition> getNutritionByUser(User user) {
	        return nutritionRepository.findByUser(user);
	    }

	    public Nutrition saveNutrition(Nutrition nutrition) {
	        return nutritionRepository.save(nutrition);
	    }
	    
	    public List<Nutrition> getAllNutritions() {
	        return nutritionRepository.findAll();
	    }
}
