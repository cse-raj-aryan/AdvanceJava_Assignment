package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@Controller
public class ProductController {

    private final ProductService productService;    //Dependency Injection


    public ProductController(ProductService productService) {    //Consturctor Injection
        this.productService = productService;
    }

    @GetMapping("/products")       //https request
    public String showProducts(Model model) {

        List<Product> productList = productService.fetchProducts();
        model.addAttribute("products", productList);     //data

        return "products";     //View name
    }
}
