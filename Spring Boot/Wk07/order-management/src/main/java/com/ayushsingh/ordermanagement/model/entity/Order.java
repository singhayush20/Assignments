package com.ayushsingh.ordermanagement.model.entity;


import com.ayushsingh.ordermanagement.model.constants.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ecom_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "order_token", unique = true, nullable = false)
    private String orderToken;

    @Column(name="order_status",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(name="address",nullable = false)
    private String address;

    @Column(name="customer_name",nullable = false)
    private String customerName;

    @Column(name="shipment_code",unique = true)
    private String shipmentCode;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH}, orphanRemoval = true)
    private Set<OrderItem> orderItems = new HashSet<>();

    @PreRemove
    private void preRemove() {
        for (OrderItem orderItem : orderItems) {
            orderItem.setOrder(null);
        }
        orderItems.clear();
    }

    @CreatedDate
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderToken, order.orderToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderToken);
    }
}
