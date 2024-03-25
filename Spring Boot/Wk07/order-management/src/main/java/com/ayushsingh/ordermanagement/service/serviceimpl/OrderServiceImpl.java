package com.ayushsingh.ordermanagement.service.serviceimpl;

import com.ayushsingh.ordermanagement.model.constants.OrderStatus;
import com.ayushsingh.ordermanagement.model.dto.Order.OrderCreateDto;
import com.ayushsingh.ordermanagement.model.dto.Order.OrderDetailsDto;
import com.ayushsingh.ordermanagement.model.dto.Order.OrderUpdateDto;
import com.ayushsingh.ordermanagement.model.dto.Order.OrderItemDto;
import com.ayushsingh.ordermanagement.model.dto.Shipment.ShipmentCreateDto;
import com.ayushsingh.ordermanagement.model.entity.Order;
import com.ayushsingh.ordermanagement.model.entity.OrderItem;
import com.ayushsingh.ordermanagement.model.entity.Product;
import com.ayushsingh.ordermanagement.model.projection.ListOrderProjection;
import com.ayushsingh.ordermanagement.repository.OrderItemRepository;
import com.ayushsingh.ordermanagement.repository.OrderRepository;
import com.ayushsingh.ordermanagement.repository.ProductRepository;
import com.ayushsingh.ordermanagement.service.OrderService;
import com.ayushsingh.ordermanagement.util.exceptionUtil.ApiException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


import java.util.*;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;
    private final RestClient restClient;

    public OrderServiceImpl(OrderRepository orderRepository, OrderItemRepository orderItemRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
        this.restClient = RestClient.builder()
                .baseUrl("http://localhost:8086")
                .build();
    }

    @Override
    public String placeNewOrder(OrderCreateDto orderCreateDto) {

        Order order = new Order();
        order.setOrderStatus(OrderStatus.PLACED);
        order.setAddress(orderCreateDto.getAddress());
        order.setCustomerName(orderCreateDto.getCustomerName());
        order.setOrderToken(UUID.randomUUID().toString());
        Set<OrderItemDto> itemList = orderCreateDto.getProducts();
        Set<OrderItem> orderItems = new HashSet<>();
        if (itemList.isEmpty()) {
            throw new ApiException("Order cannot be empty!");
        }
        for (OrderItemDto orderItemDto : itemList) {
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(orderItemDto.getQuantity());
            orderItem.setOrder(order);
            Product product = productRepository.findByProductToken(orderItemDto.getProductToken()).orElseThrow(() -> new ApiException("Product with id: " + orderItemDto.getProductToken() + " not found!"));
            if (product.getStockQuantity() < orderItemDto.getQuantity()) {
                throw new ApiException("Insufficient stock for product: " + product.getProductName());
            }
            orderItem.setProduct(product);
            orderItems.add(orderItem);
        }
        order.setOrderItems(orderItems);
        ShipmentCreateDto shipmentCreateDto = new ShipmentCreateDto();
        shipmentCreateDto.setOrderToken(order.getOrderToken());
       Map<String,Object> response = restClient.post()
                .uri("/api/v1/shipment/create")
                .contentType(MediaType.APPLICATION_JSON)
                .body(shipmentCreateDto)
                .retrieve()
                .body(Map.class);
       log.debug("Response: " + response);
       Integer code=(Integer) response.get("code");
       if(code!=2000){
           throw new ApiException("Shipment could not be created!");
       }
        Map<String,Object> responseData=(Map<String,Object>) response.get("data");
        order.setShipmentCode((String) responseData.get("shipmentCode"));
        orderRepository.save(order);

        return "Order with id: " + order.getOrderToken() + " created successfully!";
    }

    @Override
    public OrderDetailsDto orderDetails(String orderToken) {
        Optional<Order> orderOptional = orderRepository.findByOrderToken(orderToken);
        if (orderOptional.isEmpty()) {
            throw new ApiException("Order with id: " + orderToken + " not found!");
        }
        Order order = orderOptional.get();
        OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
        orderDetailsDto.setOrderToken(order.getOrderToken());
        orderDetailsDto.setCustomerName(order.getCustomerName());
        orderDetailsDto.setAddress(order.getAddress());
        orderDetailsDto.setOrderStatus(order.getOrderStatus());
        orderDetailsDto.setOrderItems(orderItemRepository.findOrderItemDetailsByOrderToken(orderToken));
        return orderDetailsDto;
    }

    @Transactional
    @Override
    public String cancelOrder(String orderToken) {
        orderItemRepository.deleteByOrderToken(orderToken);
        orderRepository.deleteByOrderToken(orderToken);
        Map<String,Object> response = restClient.delete()
                .uri("/api/v1/shipment/cancel/{orderToken}", orderToken)
                .retrieve()
                .body(Map.class);
        Integer responseCode=(Integer) response.get("code");
        if(responseCode!=2000){
            throw new ApiException("Shipment could not be deleted!");
        }
        return "Order with id: " + orderToken + " deleted successfully!";
    }

    @Override
    public String updateOrder(String orderToken, OrderUpdateDto orderUpdateDto) {
        Optional<Order> orderOptional = orderRepository.findByOrderToken(orderToken);

        if (orderOptional.isEmpty()) {
            throw new ApiException("Order with id: " + orderToken + " not found!");
        }
        Order order = orderOptional.get();
        order.setAddress(orderUpdateDto.getAddress());
        order.setCustomerName(orderUpdateDto.getCustomerName());
        orderRepository.save(order);
        return orderToken;
    }

    @Override
    public List<ListOrderProjection> getAllOrders() {
        return orderRepository.findAllOrders();
    }


}
