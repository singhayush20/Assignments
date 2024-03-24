package com.ayushsingh.shipment.controller;

import com.ayushsingh.shipment.constants.AppConstants;
import com.ayushsingh.shipment.model.dto.ShipmentCreateDto;
import com.ayushsingh.shipment.model.dto.ShipmentDetailsDto;
import com.ayushsingh.shipment.service.ShipmentService;
import com.ayushsingh.shipment.util.responseUtil.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shipment")
public class ShipmentController {

    private final ShipmentService shipmentService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<ShipmentDetailsDto>> createShipment(@RequestBody ShipmentCreateDto shipmentCreateDto) {
        return ResponseEntity.ok(new ApiResponse<>(AppConstants.SUCCESS_MESSAGE, shipmentService.createShipment(shipmentCreateDto), AppConstants.SUCCESS_CODE));
    }

    @DeleteMapping("/cancel/{shipmentCode}")
    public ResponseEntity<ApiResponse<Boolean>> cancelShipment(@PathVariable String shipmentCode) {
        return ResponseEntity.ok(new ApiResponse<>(AppConstants.SUCCESS_MESSAGE, shipmentService.cancelShipment(shipmentCode), AppConstants.SUCCESS_CODE));
    }
}
