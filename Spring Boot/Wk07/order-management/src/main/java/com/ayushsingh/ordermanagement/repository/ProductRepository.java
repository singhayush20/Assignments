package com.ayushsingh.ordermanagement.repository;

import com.ayushsingh.ordermanagement.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}