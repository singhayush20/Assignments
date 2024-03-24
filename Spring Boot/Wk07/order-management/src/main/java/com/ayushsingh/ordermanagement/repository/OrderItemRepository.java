package com.ayushsingh.ordermanagement.repository;

import com.ayushsingh.ordermanagement.model.entity.OrderItem;
import com.ayushsingh.ordermanagement.model.projection.OrderItemDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {


    @Query("""
            select
            oi.product.productToken as productToken,
            oi.product.productName as productName,
            oi.quantity as quantity
            from OrderItem oi
            where oi.order.orderToken = :orderToken
            """)
    List<OrderItemDetailsProjection> findOrderItemDetailsByOrderToken(String orderToken);
}
