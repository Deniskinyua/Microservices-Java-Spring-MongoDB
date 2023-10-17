package com.microservices.productservice.service;

import com.microservices.productservice.dto.ProductRequest;
import com.microservices.productservice.model.Product;
import com.microservices.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    //To be able to save to db, we must call the ProductRepository interface
    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();


        //Save to Database
        productRepository.save(product);
        //Log
        log.info(" {}", product.getId());
    }
}

