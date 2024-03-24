package com.ayushsingh.ordermanagement.repository;

import com.ayushsingh.ordermanagement.model.entity.Order;
import com.ayushsingh.ordermanagement.model.projection.ListOrderProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Modifying
    @Query("delete from Order o where o.orderToken = ?1")
    void deleteByOrderToken(String orderToken);


    @Query("select o from Order o where o.orderToken = ?1")
    Optional<Order> findByOrderToken(String orderToken);

    @Query("""
            select
            o.address as address,
            o.customerName as customerName,
            o.orderToken as orderToken,
            o.orderStatus as orderStatus,
            o.createdAt as orderDate
            from Order o order by o.createdAt desc
            """)
    List<ListOrderProjection> findAllOrders();
}