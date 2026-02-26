package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository empRepository;

    public EmployeeService(EmployeeRepository empRepository) {
        this.empRepository = empRepository;
    }

    public List<Employee> getAllEmployees() {
        return empRepository.findAll();
    }
    
    public void saveEmployee(Employee employee) {
        empRepository.save(employee);
    }
}