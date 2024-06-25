package com.Maliki.health_fitness_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Maliki.health_fitness_app.models.User;
import com.Maliki.health_fitness_app.models.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Long>{

	List<Workout> findByUser(User user);
}
