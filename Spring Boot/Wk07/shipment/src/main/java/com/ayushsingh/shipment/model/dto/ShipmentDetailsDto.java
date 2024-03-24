package com.ayushsingh.shipment.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentDetailsDto {

    private String shipmentCode;

    private String currentShipmentLocation;

    private String orderToken;
}
