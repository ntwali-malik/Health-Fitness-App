package com.Maliki.health_fitness_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Maliki.health_fitness_app.models.Nutrition;
import com.Maliki.health_fitness_app.models.User;

public interface NutritionRepository extends JpaRepository<Nutrition, Long>{
	List<Nutrition> findByUser(User user);
}
