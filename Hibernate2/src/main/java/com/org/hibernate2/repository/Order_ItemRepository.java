package com.org.hibernate2.repository;

import com.org.hibernate2.model.Order_Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Order_ItemRepository extends JpaRepository<Order_Item, Integer> {

    List<Order_Item> findAllByOrderId(int id);
}
