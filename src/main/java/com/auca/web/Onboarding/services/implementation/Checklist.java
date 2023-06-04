package com.example.Onboarding.services.implementation;

import com.example.Onboarding.model.employee;
import com.example.Onboarding.repository.employeeRepository;
import com.example.Onboarding.services.employeeService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Checklist implements checklist {

    private final TasksRepo employeeRepository;

    public Checklist(TasksRepo employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public employee savedemployee(employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<employee> GetAllemployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteemployee(String email) {
        employeeRepository.deleteById(email);
    }
}
