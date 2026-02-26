package com.example.demo.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@Controller
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/customers")
    public String viewCustomers(Model model) {
        List<Customer> customers = service.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customer";
    }

    @GetMapping("/addCustomer")
    public String showAddCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "addCustomer";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute Customer customer) {
        service.addCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/editCustomer/{id}")
    public String showUpdateCustomerForm(@PathVariable Long id, Model model) {
        Customer customer = service.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "updateCustomer";
    }

    @PostMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute Customer customer) {
        service.updateCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
        return "redirect:/customers";
    }
}