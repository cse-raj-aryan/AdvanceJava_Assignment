package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDAO;
import com.example.demo.model.Product;

@Service
public class ProductService {

    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> fetchProducts() {
        return productDAO.getAllProducts();
    }
}
