package com.org.hibernate2.repository;

import com.org.hibernate2.model.Client;
import com.org.hibernate2.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepoitory extends JpaRepository<Order, Integer> {

    List<Order> findAllByClient(Client client);
    Order getOrderById(int id);

}
