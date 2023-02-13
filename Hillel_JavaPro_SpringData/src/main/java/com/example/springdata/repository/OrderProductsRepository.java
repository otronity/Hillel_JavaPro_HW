package com.example.springdata.repository;

import com.example.springdata.model.OrderProducts;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderProductsRepository extends CrudRepository<OrderProducts, Long> {

    List<OrderProducts> getOrderProductsByOrderid(Integer id);
}
