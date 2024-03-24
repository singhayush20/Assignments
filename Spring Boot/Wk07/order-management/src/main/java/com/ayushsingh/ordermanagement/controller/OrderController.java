package com.ayushsingh.ordermanagement.controller;

import com.ayushsingh.ordermanagement.model.dto.Order.OrderCreateDto;
import com.ayushsingh.ordermanagement.model.dto.Order.OrderDetailsDto;
import com.ayushsingh.ordermanagement.model.dto.Order.OrderUpdateDto;
import com.ayushsingh.ordermanagement.model.projection.ListOrderProjection;
import com.ayushsingh.ordermanagement.service.OrderService;
import com.ayushsingh.ordermanagement.util.responseUtil.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/new")
    public ResponseEntity<ApiResponse<String>> createOrder(@RequestBody OrderCreateDto orderCreateDto) {
        String token = orderService.placeNewOrder(orderCreateDto);
        return new ResponseEntity<>(new ApiResponse<>(token), HttpStatus.CREATED);
    }

    @GetMapping("/{orderToken}")
    public ResponseEntity<ApiResponse<OrderDetailsDto>> getOrderDetails(@PathVariable String orderToken) {
        OrderDetailsDto orderDetailsDto = orderService.orderDetails(orderToken);
        return ResponseEntity.ok(new ApiResponse<>(orderDetailsDto));
    }

    @DeleteMapping("/{orderToken}")
    public ResponseEntity<ApiResponse<String>> cancelOrder(@PathVariable String orderToken) {
        String message = orderService.cancelOrder(orderToken);
        return ResponseEntity.ok(new ApiResponse<>(message));
    }

    @PatchMapping("/{orderToken}")
    public ResponseEntity<ApiResponse<String>> updateOrder(@PathVariable String orderToken, @RequestBody OrderUpdateDto orderUpdateDto) {
        String message = orderService.updateOrder(orderToken, orderUpdateDto);
        return ResponseEntity.ok(new ApiResponse<>(message));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<ListOrderProjection>>> getAllOrders() {
        List<ListOrderProjection> orders = this.orderService.getAllOrders();
        return ResponseEntity.ok(new ApiResponse<>(orders));
    }
}