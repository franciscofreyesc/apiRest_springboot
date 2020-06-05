package com.init.products.productapi.dao;

import com.init.products.productapi.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product, Long> {
    
}