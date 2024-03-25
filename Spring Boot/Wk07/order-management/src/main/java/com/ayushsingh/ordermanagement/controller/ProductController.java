package com.ayushsingh.ordermanagement.controller;

import com.ayushsingh.ordermanagement.model.projection.ListProductProjection;
import com.ayushsingh.ordermanagement.service.ProductService;
import com.ayushsingh.ordermanagement.util.responseUtil.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @RequestMapping("/all")
    public ResponseEntity<ApiResponse<List<ListProductProjection>>> getAllProducts() {
        return new ResponseEntity<>(new ApiResponse<>(productService.getAllProducts()), HttpStatus.OK);
    }

}
