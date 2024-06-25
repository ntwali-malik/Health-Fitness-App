package com.Maliki.health_fitness_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Maliki.health_fitness_app.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
