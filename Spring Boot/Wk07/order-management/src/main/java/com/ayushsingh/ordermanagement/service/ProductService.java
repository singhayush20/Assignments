package com.ayushsingh.ordermanagement.service;

import com.ayushsingh.ordermanagement.model.projection.ListProductProjection;

import java.util.List;

public interface ProductService {

    List<ListProductProjection> getAllProducts();
}
