package com.example.Onboarding.repository;

import com.example.Onboarding.model.TasksRepo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepo extends JpaRepository<TasksRepo, String> {
}
