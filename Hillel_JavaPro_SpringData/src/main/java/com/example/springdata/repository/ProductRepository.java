package com.example.springdata.repository;

import com.example.springdata.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    Product getProductsById(Integer id);

}
