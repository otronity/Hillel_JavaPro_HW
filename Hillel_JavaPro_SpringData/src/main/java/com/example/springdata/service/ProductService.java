package com.example.springdata.service;

import com.example.springdata.dto.ProductDto;
import com.example.springdata.model.Product;
import com.example.springdata.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;

    public ProductDto createProduct(ProductDto productDto){
        Product product = objectMapper.convertValue(productDto, Product.class);
        productRepository.save(product);
        productDto.setId(product.getId());
        return productDto;
    }

}
