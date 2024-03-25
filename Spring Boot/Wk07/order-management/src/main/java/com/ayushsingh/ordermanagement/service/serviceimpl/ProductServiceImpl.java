package com.ayushsingh.ordermanagement.service.serviceimpl;

import com.ayushsingh.ordermanagement.model.projection.ListProductProjection;
import com.ayushsingh.ordermanagement.repository.ProductRepository;
import com.ayushsingh.ordermanagement.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public List<ListProductProjection> getAllProducts() {
        return productRepository.getAllProducts();
    }
}
