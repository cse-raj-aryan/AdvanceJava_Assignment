package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public void addCustomer(Customer customer) {
        repository.save(customer);
    }

    public Customer getCustomerById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void updateCustomer(Customer customer) {
        repository.save(customer);
    }

    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
}