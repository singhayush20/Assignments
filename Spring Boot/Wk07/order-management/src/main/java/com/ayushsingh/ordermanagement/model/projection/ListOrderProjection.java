package com.ayushsingh.ordermanagement.model.projection;

import com.ayushsingh.ordermanagement.model.constants.OrderStatus;

import java.util.Date;

public interface ListOrderProjection {

    String getAddress();

    String getCustomerName();

    OrderStatus getOrderStatus();

    Date getOrderDate();

    String getOrderToken();
}
