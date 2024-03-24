package com.ayushsingh.ordermanagement.service.serviceimpl;

import com.ayushsingh.ordermanagement.model.constants.OrderStatus;
import com.ayushsingh.ordermanagement.model.dto.Order.OrderCreateDto;
import com.ayushsingh.ordermanagement.model.dto.Order.OrderDetailsDto;
import com.ayushsingh.ordermanagement.model.dto.Order.OrderUpdateDto;
import com.ayushsingh.ordermanagement.model.dto.Product.OrderItemDto;
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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;

    @Override
    public String placeNewOrder(OrderCreateDto orderCreateDto) {

        Order order = new Order();
        order.setOrderStatus(OrderStatus.PLACED);
        order.setAddress(orderCreateDto.getAddress());
        order.setCustomerName(orderCreateDto.getCustomerName());
        Set<OrderItemDto> itemList = orderCreateDto.getProducts();
        Set<OrderItem> orderItems = new HashSet<>();
        if (itemList.isEmpty()) {
            throw new ApiException("Order cannot be empty!");
        }
        for (OrderItemDto orderItemDto : itemList) {
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(orderItemDto.getQuantity());
            orderItem.setOrder(order);
            Product product = productRepository.findByProductToken(orderItemDto.getProductName()).orElseThrow(() -> new ApiException("Product with id: " + orderItemDto.getProductName() + " not found!"));
            if (product.getStockQuantity() < orderItemDto.getQuantity()) {
                throw new ApiException("Insufficient stock for product: " + product.getProductName());
            }
            orderItem.setProduct(product);
            orderItems.add(orderItem);
        }
        order.setOrderItems(orderItems);
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
        orderRepository.deleteByOrderToken(orderToken);
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
        return orderUpdateDto.getOrderToken();
    }

    @Override
    public List<ListOrderProjection> getAllOrders() {
        return orderRepository.findAllOrders();
    }


}
