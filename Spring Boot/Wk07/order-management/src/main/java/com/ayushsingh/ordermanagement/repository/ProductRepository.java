package com.ayushsingh.ordermanagement.repository;

import com.ayushsingh.ordermanagement.model.entity.Product;
import com.ayushsingh.ordermanagement.model.projection.ListProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query("SELECT p FROM Product p WHERE p.productToken = ?1")
    Optional<Product> findByProductToken(String productToken);

    @Query("""
            select
            p.productToken as productToken,
            p.productName as productName
            from Product p
            """)
    List<ListProductProjection> getAllProducts();
}