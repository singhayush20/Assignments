package com.ayushsingh.ordermanagement.model.dto.Order;

import com.ayushsingh.ordermanagement.model.constants.OrderStatus;
import com.ayushsingh.ordermanagement.model.projection.OrderItemDetailsProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDto {

    private String orderToken;
    private OrderStatus orderStatus;
    private String address;
    private String customerName;
    private List<OrderItemDetailsProjection> orderItems = new ArrayList<>();
}
