package com.example.springsecurity.service;

import com.example.springsecurity.dto.ProductDto;
import com.example.springsecurity.model.Product;
import com.example.springsecurity.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;

    public ProductDto createProduct(ProductDto productDto) {
        if (productDto == null) {
            log.info("Product is Null");
            return new ProductDto();
        }
        var product = objectMapper.convertValue(productDto, Product.class);
        productRepository.save(product);
        productDto.setId(product.getId());
        return productDto;
    }


    public ProductDto getById(int id) {
        var byId = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No product with such ID!"));
        return objectMapper.convertValue(byId, ProductDto.class);
    }

    public List<ProductDto> getAllProducts() {
        var productList = (List<Product>) productRepository.findAll();
        return productList.stream()
                .map(product -> objectMapper.convertValue(product, ProductDto.class)).toList();
    }

    public void removeAllProducts() {
        productRepository.deleteAll();
    }

    public void removeProductById(int productId) {
        var byId = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product ID = " + productId + " not found!"));
        productRepository.delete(byId);
    }

}
