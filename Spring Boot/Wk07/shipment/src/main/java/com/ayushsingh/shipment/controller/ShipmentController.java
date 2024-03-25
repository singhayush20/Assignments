package com.ayushsingh.shipment.controller;

import com.ayushsingh.shipment.constants.AppConstants;
import com.ayushsingh.shipment.model.dto.ShipmentCreateDto;
import com.ayushsingh.shipment.model.dto.ShipmentDetailsDto;
import com.ayushsingh.shipment.service.ShipmentService;
import com.ayushsingh.shipment.util.responseUtil.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shipment")
public class ShipmentController {

    private final ShipmentService shipmentService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<ShipmentDetailsDto>> createShipment(@RequestBody ShipmentCreateDto shipmentCreateDto) {
        return new ResponseEntity<>(new ApiResponse<>(shipmentService.createShipment(shipmentCreateDto)), HttpStatus.CREATED);
    }

    @DeleteMapping("/cancel/{orderToken}")
    public ResponseEntity<ApiResponse<Boolean>> cancelShipment(@PathVariable String orderToken) {
        return ResponseEntity.ok(new ApiResponse<>(AppConstants.SUCCESS_MESSAGE, shipmentService.cancelShipment(orderToken), AppConstants.SUCCESS_CODE));
    }
}
