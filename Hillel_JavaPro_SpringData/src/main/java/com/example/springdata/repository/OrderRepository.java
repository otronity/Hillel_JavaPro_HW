package com.example.springdata.repository;

import com.example.springdata.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    Order getOrderById(Integer id);

}
