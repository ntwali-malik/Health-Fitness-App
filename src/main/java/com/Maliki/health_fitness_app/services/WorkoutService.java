package com.Maliki.health_fitness_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Maliki.health_fitness_app.models.User;
import com.Maliki.health_fitness_app.models.Workout;
import com.Maliki.health_fitness_app.repository.WorkoutRepository;

@Service
public class WorkoutService {

	@Autowired
    private WorkoutRepository workoutRepository;

	public List<Workout> getWorkoutsByUser(User user) {
        return workoutRepository.findByUser(user);
    }

    public Workout saveWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }
}
