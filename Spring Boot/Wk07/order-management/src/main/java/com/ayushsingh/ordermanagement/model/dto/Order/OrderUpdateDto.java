package com.ayushsingh.ordermanagement.model.dto.Order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderUpdateDto {

    private String orderToken;
    private String address;
    private String customerName;
}
