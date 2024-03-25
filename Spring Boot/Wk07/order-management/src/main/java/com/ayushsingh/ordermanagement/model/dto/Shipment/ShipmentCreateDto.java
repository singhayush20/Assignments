package com.ayushsingh.ordermanagement.model.dto.Shipment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentCreateDto {
    private String orderToken;
}
