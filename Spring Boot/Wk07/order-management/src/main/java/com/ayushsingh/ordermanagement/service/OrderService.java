package com.ayushsingh.ordermanagement.service;

import com.ayushsingh.ordermanagement.model.dto.Order.OrderCreateDto;
import com.ayushsingh.ordermanagement.model.dto.Order.OrderDetailsDto;

public interface OrderService {

    String placeNewOrder(OrderCreateDto orderCreateDto);

    OrderDetailsDto orderDetails(String orderToken);

    String cancelOrder(String orderToken);

    String updateOrder(String orderToken, OrderCreateDto orderCreateDto);
}
