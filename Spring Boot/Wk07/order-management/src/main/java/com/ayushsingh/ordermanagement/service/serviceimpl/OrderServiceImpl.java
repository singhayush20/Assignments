package com.ayushsingh.ordermanagement.service.serviceimpl;

import com.ayushsingh.ordermanagement.model.dto.Order.OrderCreateDto;
import com.ayushsingh.ordermanagement.model.dto.Order.OrderDetailsDto;
import com.ayushsingh.ordermanagement.service.OrderService;

public class OrderServiceImpl implements OrderService {
    @Override
    public String placeNewOrder(OrderCreateDto orderCreateDto) {
        return null;
    }

    @Override
    public OrderDetailsDto orderDetails(String orderToken) {
        return null;
    }

    @Override
    public String cancelOrder(String orderToken) {

    }

    @Override
    public String updateOrder(String orderToken, OrderCreateDto orderCreateDto) {
        return null;
    }
}
