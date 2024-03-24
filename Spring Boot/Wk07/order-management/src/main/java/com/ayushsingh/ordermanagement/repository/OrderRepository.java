package com.ayushsingh.ordermanagement.repository;

import com.ayushsingh.ordermanagement.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}