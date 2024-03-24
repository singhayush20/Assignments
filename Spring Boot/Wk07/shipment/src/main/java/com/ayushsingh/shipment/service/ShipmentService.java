package com.ayushsingh.shipment.service;

import com.ayushsingh.shipment.model.dto.ShipmentCreateDto;
import com.ayushsingh.shipment.model.dto.ShipmentDetailsDto;

public interface ShipmentService {

    ShipmentDetailsDto createShipment(ShipmentCreateDto shipmentCreateDto);

    Boolean cancelShipment(String shipmentCode);
}
