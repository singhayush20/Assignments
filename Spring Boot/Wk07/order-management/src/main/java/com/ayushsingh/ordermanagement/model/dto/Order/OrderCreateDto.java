package com.ayushsingh.ordermanagement.model.dto.Order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateDto {

    private String address;
    private String customerName;
    private Set<OrderItemDto> products=new HashSet<>();
}
