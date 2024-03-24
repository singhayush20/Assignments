package com.ayushsingh.ordermanagement.service;

import com.ayushsingh.ordermanagement.model.dto.Order.OrderCreateDto;
import com.ayushsingh.ordermanagement.model.dto.Order.OrderDetailsDto;
import com.ayushsingh.ordermanagement.model.dto.Order.OrderUpdateDto;
import com.ayushsingh.ordermanagement.model.projection.ListOrderProjection;

import java.util.List;

public interface OrderService {

    String placeNewOrder(OrderCreateDto orderCreateDto);

    OrderDetailsDto orderDetails(String orderToken);

    String cancelOrder(String orderToken);

    String updateOrder(String orderToken, OrderUpdateDto orderUpdateDto);

    List<ListOrderProjection> getAllOrders();
}
