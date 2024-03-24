package com.ayushsingh.ordermanagement.repository;

import com.ayushsingh.ordermanagement.model.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
