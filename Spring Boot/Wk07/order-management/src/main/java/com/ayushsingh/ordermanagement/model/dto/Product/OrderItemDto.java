package com.ayushsingh.ordermanagement.model.dto.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {
    private String productName;
    private String productToken;
    private Long quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemDto that = (OrderItemDto) o;
        return Objects.equals(productName, that.productName) && Objects.equals(productToken, that.productToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, productToken);
    }
}
